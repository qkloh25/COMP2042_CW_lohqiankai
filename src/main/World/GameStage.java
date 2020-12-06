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

	// initialize the actors.
	End End1 = new End(11,96);
	End End2 = new End(11 + 120,96);
	End End3 = new End(11 + 120 + 120,96);
	End End4 = new End(11 + 120 + 120 + 120,96);
	End End5 = new End(11 + 120 + 120 + 120 + 120,96);

	Log Log1 = new Log("file:src/pics/logs.png", 270, 0, 260, -2);
	Log Log2 = new Log("file:src/pics/logs.png", 270, 400, 260, -2);
	Log Log3 = new Log("file:src/pics/log3.png", 135, 50, 310, 0.75);
	Log Log4 = new Log("file:src/pics/log3.png", 135, 490, 310, 0.75);
	Log Log5 = new Log("file:src/pics/log3.png", 135, 270, 310, 0.75);

	Turtle Turtle1 = new Turtle(500, 350, -1, 120, 120);
	Turtle Turtle2 = new Turtle(300, 350, -1, 120, 120);
	WetTurtle WetTurtle1 = new WetTurtle(700, 350, -1, 120, 120);
	WetTurtle WetTurtle2 = new WetTurtle(600, 205, -1, 120, 120);
	WetTurtle WetTurtle3 = new WetTurtle(400, 205, -1, 120, 120);
	WetTurtle WetTurtle4 =new WetTurtle(200, 205, -1, 120, 120);

	Obstacle truck1 = new Obstacle("file:src/pics/truck1"+"Right.png", 0, 655, 1, 110, 110);
	Obstacle truck2 = new Obstacle("file:src/pics/truck1"+"Right.png", 300, 655, 1, 110, 110);
	Obstacle truck3 = new Obstacle("file:src/pics/truck1"+"Right.png", 600, 655, 1, 110, 110);
	Obstacle car1 = new Obstacle("file:src/pics/car1Left.png", 100, 605, -1, 50, 50);
	Obstacle car2 = new Obstacle("file:src/pics/car1Left.png", 250, 605, -1, 50, 50);
	Obstacle car3 = new Obstacle("file:src/pics/car1Left.png", 400, 605, -1, 50, 50);

	Obstacle truck4 = new Obstacle("file:src/pics/truck2Right.png", 0, 555, 1, 200, 200);
	Obstacle truck5 = new Obstacle("file:src/pics/truck2Right.png", 500, 555, 1, 200, 200);

	Obstacle quickcar1 = new Obstacle("file:src/pics/car1Left.png", 500, 505, -5, 50, 50);
	Obstacle quickcar2 = new Obstacle("file:src/pics/car1right.png", 500, 455, 4, 50, 50);

	@Override
	public void act(long now) {
		
	}
	
	public GameStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
		ImageView froggerback = new ImageView(new Image("file:src/pics/iKogsKW.png", 600, 800, true, true));
		getChildren().add(froggerback);

		add(new Log("file:src/pics/log3.png", 135, 0, 160, 1));
		add(new Log("file:src/pics/log3.png", 135, 220, 160, 1));
		add(new Log("file:src/pics/log3.png", 135, 440, 160, 1));
		add(Log1);
		add(Log2);
		add(Log3);
		add(Log4);
		add(Log5);
		add(Turtle1);
		add(Turtle2);
		add(WetTurtle1);
		add(WetTurtle2);
		add(WetTurtle3);
		add(WetTurtle4);
		add(truck1);
		add(truck2);
		add(truck3);
		//add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		add(car1);
		add(car2);
		add(car3);

		add(truck4);
		add(truck5);
		add(quickcar1);
		add(quickcar2);

		getChildren().addAll(End1,End2,End3,End4, End5);
		frog = new Animal("file:src/pics/froggerUp.png");
		add(frog);
		add(new Digit(0, 30, 525, 35));
		add(new Digit(3, 30, 75, 755));
		add(new Digit(1, 40, 330, 35,'w'));

		ImageView heart = new ImageView(new Image("file:src/pics/heart.png", 40, 40, true, true));
		heart.setTranslateY(750);
		heart.setTranslateX(10);
		getChildren().add(heart);

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
					board.setTranslateX(130);
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
								increaseDifficultyBySpeed();
								frog.resetPoints();
								playMusic();
								getChildren().add(frog);
								setRoundNum(scores.size()+1);
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

	public void setRoundNum(int n){
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			add(new Digit(k, 40, 330 - shift, 33,'w'));
			shift+=25;
		}

	}
	public void resetEnd(){
		End1.reset();
		End2.reset();
		End3.reset();
		End4.reset();
		End5.reset();
	}

	public void increaseDifficultyBySpeed(){
		Log1.setSpeed(-2 + -0.3*scores.size());
		Log2.setSpeed(-2 + -0.3*scores.size());
		Log3.setSpeed(0.75 + 0.3*scores.size());
		Log4.setSpeed(0.75 + 0.3*scores.size());
		Log5.setSpeed(0.75 + 0.3*scores.size());

		Turtle1.setSpeed(-1 + -0.25*scores.size());
		Turtle2.setSpeed(-1 + -0.25*scores.size());
		WetTurtle1.setSpeed(-1 + -0.25*scores.size());
		WetTurtle2.setSpeed(-1 + -0.25*scores.size());
		WetTurtle3.setSpeed(-1 + -0.25*scores.size());
		WetTurtle4.setSpeed(-1 + -0.25*scores.size());

		truck1.setSpeed(1 + 0.15 *scores.size());
		truck2.setSpeed(1 + 0.15 *scores.size());
		truck3.setSpeed(1 + 0.15 *scores.size());
		truck4.setSpeed(1 + 0.15 *scores.size());
		truck5.setSpeed(1 + 0.15 *scores.size());

		car1.setSpeed(-1 + -0.15* scores.size());
		car2.setSpeed(-1 + -0.15* scores.size());
		car3.setSpeed(-1 + -0.15* scores.size());


		quickcar1.setSpeed(-5 + -0.5*scores.size());
		quickcar2.setSpeed(4 + 0.3*scores.size());
	}
}
