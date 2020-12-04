package main.Actors;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import main.World.World;

import java.util.ArrayList;


public abstract class Actor extends ImageView{

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

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
