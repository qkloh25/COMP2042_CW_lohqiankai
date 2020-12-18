package main.Actors;

import javafx.scene.image.Image;

/**
 * Digits, to show the value.
 */
public class Digit extends Actor {
	public static final String FILE_SRC_PICS = "file:src/res/pics/";
	int dim;
	Image im1;
	char color;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	public Digit(int n, int dim, int x, int y) {
		this.dim = dim;
		im1 = new Image(FILE_SRC_PICS +n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
	public Digit(int n, int dim, int x, int y,char c) {
		this.dim = dim;
		color = c;
		if(c=='g') {
			im1 = new Image(FILE_SRC_PICS+"g" + n + ".png", dim, dim, true, true);

		}else if(c == 'w'){
			color = c;
			im1 = new Image(FILE_SRC_PICS+"w" + n + ".png", dim, dim, true, true);
		}else if(c == 'r'){
			color = c;
			im1 = new Image(FILE_SRC_PICS+"r" + n + ".png", dim, dim, true, true);
		}
		setImage(im1);
		setX(x);
		setY(y);
	}

	/**
	 * Change image to the desired value.
	 * @param n the desired value.
	 */
	public void changeImage(int n){
		im1 = new Image(FILE_SRC_PICS + color+ n + ".png", dim, dim, true, true);
		setImage(im1);

	}
	
}
