package main.Actors;

import javafx.scene.image.Image;

public class End extends Actor{
	public static final String FILE_SRC_PICS = "file:src/res/pics/";
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(FILE_SRC_PICS + "End.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image(FILE_SRC_PICS + "FrogEnd.png", 60, 60, true, true));
		activated = true;
	}
	public void reset() {
		setImage(new Image(FILE_SRC_PICS + "End.png", 60, 60, true, true));
		activated = false;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
