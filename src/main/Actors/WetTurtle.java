package main.Actors;

import javafx.scene.image.Image;

public class WetTurtle extends Actor implements movingCarrier {
	public static final String FILE_SRC_PICS = "file:src/res/pics/";
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private double speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -150 && speed<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image(FILE_SRC_PICS + "TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image(FILE_SRC_PICS + "TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image(FILE_SRC_PICS + "TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image(FILE_SRC_PICS + "TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
	@Override
	public double getSpeed(){
		return speed;
	}
	public void setSpeed(double speed){
		this.speed = speed;
	}
}
