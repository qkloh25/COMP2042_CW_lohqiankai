package main.World;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

import java.time.LocalDate;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.Actors.*;
import main.LeaderBoard.LeaderBoard;
import main.Main;
import main.MainMenu.MainMenu;

public class GameStage extends World {
	public final static int NUM_OF_ROUNDS = 10;
	AnimationTimer timer;
	MediaPlayer mediaPlayer;
	Animal frog;
	LeaderBoard leaderBoard;
	MainMenu mainMenu = Main.mainMenu;
	ArrayList<Integer> scores = new ArrayList<>();
	Stage primaryStage;
	End End1 = new End(11,96);
	End End2 = new End(11 + 120,96);
	End End3 = new End(11 + 120 + 120,96);
	End End4 = new End(11 + 120 + 120 + 120,96);
	End End5 = new End(11 + 120 + 120 + 120 + 120,96);
	@Override
	public void act(long now) {
		
	}
	
	public GameStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
		ImageView froggerback = new ImageView(new Image("file:src/pics/iKogsKW.png", 600, 800, true, true));
		getChildren().add(froggerback);


		add(new Log("file:src/pics/log3.png", 135, 0, 160, 1));
		add(new Log("file:src/pics/log3.png", 135, 220, 160, 1));
		add(new Log("file:src/pics/log3.png", 135, 440, 160, 1));
		//add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		add(new Log("file:src/pics/logs.png", 270, 0, 260, -2));
		add(new Log("file:src/pics/logs.png", 270, 400, 260, -2));
		//add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		add(new Log("file:src/pics/log3.png", 135, 50, 310, 0.75));
		add(new Log("file:src/pics/log3.png", 135, 270, 310, 0.75));
		add(new Log("file:src/pics/log3.png", 135, 490, 310, 0.75));
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

		getChildren().addAll(End1,End2,End3,End4, End5);
		frog = new Animal("file:src/pics/froggerUp.png");
		add(frog);
//		add(new Obstacle("file:src/pics/truck1"+"Right.png", 0, 655, 1, 110, 110));
//		add(new Obstacle("file:src/pics/truck1"+"Right.png", 300, 655, 1, 110, 110));
//		add(new Obstacle("file:src/pics/truck1"+"Right.png", 600, 655, 1, 110, 110));
//		//add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
//		add(new Obstacle("file:src/pics/car1Left.png", 100, 605, -1, 50, 50));
//		add(new Obstacle("file:src/pics/car1Left.png", 250, 605, -1, 50, 50));
//		add(new Obstacle("file:src/pics/car1Left.png", 400, 605, -1, 50, 50));
//		add(new Obstacle("file:src/pics/car1Left.png", 550, 605, -1, 50, 50));
//		add(new Obstacle("file:src/pics/truck2Right.png", 0, 555, 1, 200, 200));
//		add(new Obstacle("file:src/pics/truck2Right.png", 500, 555, 1, 200, 200));
//		add(new Obstacle("file:src/pics/car1Left.png", 500, 505, -10, 50, 50));
//		add(new Obstacle("file:src/pics/car1right.png", 500, 455, 4, 50, 50));
		add(new Digit(0, 30, 525, 35));
		add(new Digit(3, 30, 75, 755));
		ImageView heart = new ImageView(new Image("file:src/pics/heart.png", 40, 40, true, true));
		heart.setTranslateY(750);
		heart.setTranslateX(10);
		getChildren().add(heart);



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
		String musicFile = "src/audios/Gaming.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
		mediaPlayer.setVolume(0.3);
	}

	public void stopMusic() {
		mediaPlayer.stop();
	}
	//A timer for all actors to move.
	public void createTimer() {
		super.createTimer();
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (frog.changeScore()||frog.changeLife()) {
					setPointsNumber(frog.getPoints());
					setLifesNumber(frog.getLifes());

				}else if(frog.GameOver()){
					setLifesNumber(frog.getLifes());
					STOP();
					stopMusic();
					String musicFile = "src/audios/GameOver.mp3";
					Media sound = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(sound);
					mediaPlayer.setCycleCount(1);
					mediaPlayer.play();
					mediaPlayer.setVolume(1.0);
					Platform.runLater(()->{
						popupResult();
						toMainMenu();
					});

				}

				if (frog.getStop()) {
					frog.resetEnd();
					scores.add(frog.getPoints());
					getChildren().remove(frog);
					stopMusic();
					String musicFile = "src/audios/Clear.mp3";
					Media sound = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(sound);
					mediaPlayer.setCycleCount(1);
					mediaPlayer.play();
					mediaPlayer.setVolume(0.3);
					HighScoreBoard board = new HighScoreBoard(scores);
					board.setTranslateX(150);
					board.setTranslateY(200);
					getChildren().add(board);
					mediaPlayer.setOnEndOfMedia(new Runnable() {
						@Override
						public void run() {
							resetEnd();
							getChildren().remove(board);
							mediaPlayer.dispose();
							if(scores.size() == NUM_OF_ROUNDS){
								STOP();
								Platform.runLater(()->{
									popupResult();
									toMainMenu();
								});
							}
							else{
								frog.resetPoints();
								playMusic();
								getChildren().add(frog);
							}
						}
					});

//					Alert alert = new Alert(Alert.AlertType.INFORMATION);
//					alert.setTitle("You Have Won The Game!");
//					alert.setHeaderText("Your High Score: "+frog.getPoints()+"!");
//					alert.setContentText("Highest Possible Score: 800");
//					alert.show();
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

	public void popupResult(){
		TextInputDialog inputDialog = new TextInputDialog("name");
		inputDialog.setTitle("Congratulation!");
		inputDialog.setHeaderText("Let's see if you in the leaderboard!");
		inputDialog.setContentText("Enter your player name:");
		Optional<String> result = inputDialog.showAndWait();
		if (result.isPresent()) {
			LocalDateTime localDate = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			String date = dtf.format(localDate);

			leaderBoard = new LeaderBoard();
			leaderBoard.insertNewRecord(result.get(), date ,frog.getPoints());
		}
	}

	public void toMainMenu(){
		Scene mainScene = mainMenu.setupMainScene();
		primaryStage.setScene(mainScene);
	}

	public void setPointsNumber(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			add(new Digit(k, 30, 525 - shift, 35));
			shift+=23;
		}
	}
	public void setLifesNumber(int n){
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			add(new Digit(k, 30, 75 - shift, 755));
			shift+=23;
		}
	}
	public void resetEnd(){
		End1.reset();
		End2.reset();
		End3.reset();
		End4.reset();
		End5.reset();
	}
}
