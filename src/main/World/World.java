package main.World;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import main.Actors.Actor;

/**
 * The world, mainly use to control world timer, and contains actors as its children.
 */
public abstract class World extends Pane {
    private AnimationTimer timer;
    
    public World() {
    	sceneProperty().addListener(new ChangeListener<Scene>() {
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Node> myActors = getObjects(Actor.class);
							for (Node anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
					});

					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Node> myActors = getObjects(Actor.class);
							for (Node anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
					});
				}
			}
		});
    }

    /**
     * A timer that ask the actors to move.
     */

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Node> actors = getObjects(Actor.class);

                for (Node anActor: actors) {
                    ((Actor)anActor).act(now);
                }
            }
        };
    }

    /**
     * Start the timer.
     */

    public void start() {
        timer.start();
    }

    /**
     * Stop the timer.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Add the actor to this world.
     * @param actor
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Remove specific actor from this world.
     * @param actor
     */

    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * Return an array of object that is the children of this world for specified class.
     * @param cls
     * @return the array with required class.
     */
    public  List<Node> getObjects(Class cls) {
        ArrayList<Node> someArray = new ArrayList<>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add(n);
            }
        }
        return someArray;
    }

    public abstract void act(long now);
}
