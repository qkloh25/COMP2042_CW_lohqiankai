package main.World;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.Actors.*;

public class GameStage extends World {
	AnimationTimer timer;
	MediaPlayer mediaPlayer;
	Animal frog;
	@Override
	public void act(long now) {
		
	}
	
	public GameStage(Stage primaryStage) {
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
		BackgroundImage froggerback = new BackgroundImage("file:src/pics/iKogsKW.png");
		add(froggerback);
		add(new Log("file:src/pics/log3.png", 135, 0, 160, 0.75));
		add(new Log("file:src/pics/log3.png", 135, 220, 160, 0.75));
		add(new Log("file:src/pics/log3.png", 135, 440, 160, 0.75));
		//add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		add(new Log("file:src/pics/logs.png", 270, 0, 260, -2));
		add(new Log("file:src/pics/logs.png", 270, 400, 260, -2));
		//add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		add(new Log("file:src/pics/log3.png", 135, 50, 305, 0.75));
		add(new Log("file:src/pics/log3.png", 135, 270, 305, 0.75));
		add(new Log("file:src/pics/log3.png", 135, 490, 305, 0.75));
		//add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
		add(new Turtle(500, 350, -1, 120, 120));
		add(new Turtle(300, 350, -1, 120, 120));
		add(new WetTurtle(700, 350, -1, 120, 120));
		add(new WetTurtle(600, 205, -1, 120, 120));
		add(new WetTurtle(400, 205, -1, 120, 120));
		add(new WetTurtle(200, 205, -1, 120, 120));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		//add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		add(new End(11,96));
		add(new End(11 + 120,96));
		add(new End(11 + 120 + 120,96));
		add(new End(11 + 120 + 120 + 120,96));
		add(new End(11 + 120 + 120 + 120 + 120,96));
		frog = new Animal("file:src/pics/froggerUp.png");
		add(frog);
		add(new Obstacle("file:src/pics/truck1"+"Right.png", 0, 655, 1, 110, 110));
		add(new Obstacle("file:src/pics/truck1"+"Right.png", 300, 655, 1, 110, 110));
		add(new Obstacle("file:src/pics/truck1"+"Right.png", 600, 655, 1, 110, 110));
		//add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		add(new Obstacle("file:src/pics/car1Left.png", 100, 605, -1, 50, 50));
		add(new Obstacle("file:src/pics/car1Left.png", 250, 605, -1, 50, 50));
		add(new Obstacle("file:src/pics/car1Left.png", 400, 605, -1, 50, 50));
		add(new Obstacle("file:src/pics/car1Left.png", 550, 605, -1, 50, 50));
		add(new Obstacle("file:src/pics/truck2Right.png", 0, 555, 1, 200, 200));
		add(new Obstacle("file:src/pics/truck2Right.png", 500, 555, 1, 200, 200));
		add(new Obstacle("file:src/pics/car1Left.png", 500, 505, -10, 50, 50));
		add(new Obstacle("file:src/pics/car1right.png", 500, 455, 4, 50, 50));
		add(new Digit(0, 30, 360, 25));
		//add(obstacle);
		//add(obstacle1);
		//add(obstacle2);
//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();
	}

	public Scene setupGameScene(){

		return new Scene(this,565,800);
	}
	public void playMusic() {
		String musicFile = "src/audios/MainTheme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	public void stopMusic() {
		mediaPlayer.stop();
	}

	public void createTimer() {
		super.createTimer();
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (frog.changeScore()) {
					setNumber(frog.getPoints());
				}
				if (frog.getStop()) {
					System.out.print("STOPP:");
					stopMusic();
					STOP();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("You Have Won The Game!");
					alert.setHeaderText("Your High Score: "+frog.getPoints()+"!");
					alert.setContentText("Highest Possible Score: 800");
					alert.show();
				}
			}
		};
	}
	public void start() {
		createTimer();
		super.start();
		timer.start();
	}

	public void STOP() {
		super.stop();
		timer.stop();
	}
	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			add(new Digit(k, 30, 360 - shift, 25));
			shift+=30;
		}
	}


}
