package main.Actors;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/pics/End.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/pics/FrogEnd.png", 60, 60, true, true));
		activated = true;
	}
	public void reset() {
		setImage(new Image("file:src/pics/End.png", 60, 60, true, true));
		activated = false;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
