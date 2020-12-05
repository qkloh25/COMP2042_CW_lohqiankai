package main.Actors;

import javafx.scene.image.Image;

public class Log extends Actor implements movingCarrier {
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		this.speed = s;
		
	}
	@Override
	public double getSpeed(){
		return speed;
	}
	public void setSpeed(double speed){
		this.speed = speed;
	}
}
