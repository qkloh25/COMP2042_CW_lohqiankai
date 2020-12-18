package main.Actors;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import main.World.World;

import java.util.ArrayList;

/**
 * The actors in the game.
 *
 * @author lohqiankai
 * @version 1.0
 * @see Actor
 */
public abstract class Actor extends ImageView{
    /**
     * Method for the game actors/elements to move.
     * @param dx Movement in x-axis.
     * @param dy Movement in y-axis.
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Get the world of the actor.
     * @return
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Get the width of the actor.
     * @return width
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Get the height of the actor.
     * @return height
     */

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public java.util.List<Node> getIntersectingObjects(Class cls){
        ArrayList<Node> someArray = new ArrayList<Node>();
        for (Node actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public Node getOneIntersectingObject(Class cls) {
        ArrayList<Node> someArray = new ArrayList<Node>();
        for (Node actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);
}
