package main.Actors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.event.EventHandler;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Animal extends Actor {
	Image imgW1, imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
	Image carDeath1, carDeath2, carDeath3;
	Image waterDeath1, waterDeath2, waterDeath3, waterDeath4;
	int lifes = 3;
	int points = 0;
	int end = 0 ;
	private boolean secondW = false, secondA =false ,secondS =false, secondD = false;
	boolean noMove = false;
	double movement = 12.4 * 2;
	double movementX = 10.666666 * 2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	boolean changeLife = false;
	int carD = 0;
	double w = 800;






	ArrayList<End> inter = new ArrayList<End>();


	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8 + movement);
		imgW1 = new Image("file:src/pics/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/pics/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/pics/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/pics/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/pics/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/pics/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/pics/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/pics/froggerRightJump.png", imgSize, imgSize, true, true);
		carDeath1 = new Image("file:src/pics/cardeath1.png", imgSize, imgSize, true, true);
		carDeath2 = new Image("file:src/pics/cardeath2.png", imgSize, imgSize, true, true);
		carDeath3 = new Image("file:src/pics/cardeath3.png", imgSize, imgSize, true, true);
		waterDeath1 = new Image("file:src/pics/waterdeath1.png", imgSize, imgSize, true, true);
		waterDeath2 = new Image("file:src/pics/waterdeath2.png", imgSize, imgSize, true, true);
		waterDeath3 = new Image("file:src/pics/waterdeath3.png", imgSize, imgSize, true, true);
		waterDeath4 = new Image("file:src/pics/waterdeath4.png", imgSize, imgSize, true, true);

		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {
				} else {
					if (event.getCode() == KeyCode.W && !secondW) {
						move(0, -movement);
						setImage(imgW2);
						secondW = true;
						playJumpSound();
					}
					if (event.getCode() == KeyCode.A && !secondA) {
						move(-movementX, 0);
						setImage(imgA2);
						secondA = true;
						playJumpSound();
					}
					if (event.getCode() == KeyCode.S && !secondS) {
						move(0, movement);
						setImage(imgS2);
						secondS = true;
						playJumpSound();
					}
					if (event.getCode() == KeyCode.D && !secondD) {
						move(movementX, 0);
						setImage(imgD2);
						secondD = true;
						playJumpSound();
					}

				}
			}
		});

		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {
				} else {

					if (event.getCode() == KeyCode.W && secondW & getY()<679.8 + movement) {
						if (getY() < w) {
							changeScore = true;
							w = getY();
							points += 10;
						}
						move(0, -movement);
						setImage(imgW1);
						secondW = false;

					}
					if (event.getCode() == KeyCode.A && secondA) {
						move(-movementX, 0);
						setImage(imgA1);
						secondA = false;

					}
					if (event.getCode() == KeyCode.S && secondS) {
						move(0, movement);
						setImage(imgS1);
						secondS = false;

					}
					if (event.getCode() == KeyCode.D && secondD) {
						move(movementX, 0);
						setImage(imgD1);
						secondD = false;

					}

				}
			}

		});
	}

	@Override
	public void act(long now) {
		int bounds = 0;

		if (getY() < 0 || getY() > 734) {
			setX(300);
			setY(679.8 + movement);
		}
		if (getX() < 0) {
			move(movement , 0);
		}
		if (getX() > 530) {
			move(-movement , 0);
		}

		if (carDeath) {
			resetSeonds();
			noMove = true;
			if ((now) % 7 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(carDeath1);
			}
			if (carD == 2) {
				setImage(carDeath2);
			}
			if (carD == 3) {
				setImage(carDeath3);
			}
			if (carD == 4) {
				setX(300);
				setY(679.8 + movement);
				carDeath = false;
				carD = 0;
				setImage(imgW1);
				noMove = false;
				if (points > 50) {
					points -= 50;
					changeScore = true;

				}

				lifes--;
				changeLife = true;
			}

		}
		if (waterDeath) {
			resetSeonds();
			noMove = true;
			if ((now) % 7 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(waterDeath1);
			}
			if (carD == 2) {
				setImage(waterDeath2);
			}
			if (carD == 3) {
				setImage(waterDeath3);
			}
			if (carD == 4) {
				setImage(waterDeath4);
			}
			if (carD == 5) {
				setX(300);
				setY(679.8 + movement);
				waterDeath = false;
				carD = 0;
				setImage(imgW1);
				noMove = false;
				if (points > 50) {
					points -= 50;
					changeScore = true;
				}
				lifes--;
				changeLife = true;
			}

		}



		List<Node> intersectingObjects = getIntersectingObjects(Actor.class);
		if (intersectingObjects.size() >= 1) {
			Node theIntersetingObject = intersectingObjects.get(0);
			if (Obstacle.class.isInstance(theIntersetingObject)) {
				carDeath = true;
			}

			if (!noMove) {
				if (Log.class.isInstance(theIntersetingObject) || Turtle.class.isInstance(theIntersetingObject)) {
					double speed = ((movingCarrier) theIntersetingObject).getSpeed();
					move(speed, 0);
				} else if (WetTurtle.class.isInstance(theIntersetingObject)) {
					if (((WetTurtle) theIntersetingObject).isSunk()) {
						waterDeath = true;
					} else {
						double speed = ((movingCarrier) theIntersetingObject).getSpeed();
						move(speed, 0);
					}
				} else if (End.class.isInstance(theIntersetingObject)) {
					if (((End) theIntersetingObject).isActivated()) {
						points -= 50;
						waterDeath = true;
					}else if(getY()<110) {
						points += 50;
						changeScore = true;
						w = 800;
						((End) theIntersetingObject).setEnd();
						end++;
						setX(300);
						setY(679.8 + movement);
						lifes++;
						changeLife = true;
						playScoreSound();
					}
				}
			}
		}else if (getY()<380){
			waterDeath = true;
		}
	}

	public boolean getStop() {
		return end==5;
	}
	public boolean GameOver(){ return lifes==0;}
	public void resetEnd(){
		end = 0;
	}

	public int getPoints() {
		return points;
	}
	public void resetPoints(){
		points = 0;
	}
	public int getLifes(){return lifes;}
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
	public void playJumpSound(){
		String musicFile = "src/audios/jump.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer jumpMediaPlayer = new MediaPlayer(sound);
		jumpMediaPlayer.play();
		jumpMediaPlayer.setVolume(0.2);
		jumpMediaPlayer.setOnEndOfMedia(()->jumpMediaPlayer.dispose());

	}

	public void playScoreSound(){
		String musicFile = "src/audios/score.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		mediaPlayer.setOnEndOfMedia(()->mediaPlayer.dispose());

	}


	public boolean changeLife(){
		if(changeLife){
			changeLife = false;
			return true;
		}
		return false;
	}

	public void resetSeonds(){
		secondA=false;
		secondD=false;
		secondS = false;
		secondW = false;
	}
}
