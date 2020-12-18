package main.Actors;

import javafx.scene.image.Image;

/**
 * The obstacles that will kill animal in if they intersect.
 */
public class Obstacle extends Actor{
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}

	/**
	 * Obstacle that could be car, truck.
	 * @param imageLink the image link
	 * @param xpos the x coordination
	 * @param ypos the y coordination
	 * @param s the speed
	 * @param w the width
	 * @param h the hight
	 */
	
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	public void setSpeed(double speed){
		this.speed = speed;
	}
}
