package main.Actors;

import javafx.scene.image.Image;

public class Digit extends Actor {
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/pics/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
	public Digit(int n, int dim, int x, int y,char c) {
		if(c=='g') {
			im1 = new Image("file:src/pics/g" + n + ".png", dim, dim, true, true);
			setImage(im1);
			setX(x);
			setY(y);
		}else if(c == 'w'){
			im1 = new Image("file:src/pics/w" + n + ".png", dim, dim, true, true);
			setImage(im1);
			setX(x);
			setY(y);
		}
	}
	
}
