package main.Actors;

import javafx.scene.image.Image;

/**
 * The turtle that is not swimming underwater.
 */
public class Turtle extends Actor implements movingCarrier {
	public static final String FILE_SRC_PICS = "file:src/res/pics/";
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private double speed;
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -150 && speed<0)
			setX(600);
	}
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image(FILE_SRC_PICS + "TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image(FILE_SRC_PICS + "TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image(FILE_SRC_PICS + "TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	@Override
	public double getSpeed(){
		return speed;
	}
	public void setSpeed(double speed){
		this.speed = speed;
	}

}
