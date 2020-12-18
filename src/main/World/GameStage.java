package main.World;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
	public static final String FILE_SRC_PICS = "file:src/res/pics/";
	AnimationTimer timer;
	MediaPlayer mediaPlayer;
	Animal frog;
	LeaderBoard leaderBoard;
	ArrayList<Integer> scores = new ArrayList<>();
	Stage primaryStage;
	MainMenu mainMenu = Main.mainMenu;


	// initialize the actors.
	End End1 = new End(11,96);
	End End2 = new End(11 + 120,96);
	End End3 = new End(11 + 120 + 120,96);
	End End4 = new End(11 + 120 + 120 + 120,96);
	End End5 = new End(11 + 120 + 120 + 120 + 120,96);

	Log Log1 = new Log(FILE_SRC_PICS + "logs.png", 270, 0, 260, -2);
	Log Log2 = new Log(FILE_SRC_PICS + "logs.png", 270, 400, 260, -2);
	Log Log3 = new Log(FILE_SRC_PICS + "log3.png", 135, 50, 310, 0.75);
	Log Log4 = new Log(FILE_SRC_PICS + "log3.png", 135, 490, 310, 0.75);
	Log Log5 = new Log(FILE_SRC_PICS + "log3.png", 135, 270, 310, 0.75);

	Turtle Turtle1 = new Turtle(500, 350, -1, 120, 120);
	Turtle Turtle2 = new Turtle(300, 350, -1, 120, 120);
	WetTurtle WetTurtle1 = new WetTurtle(700, 350, -1, 120, 120);
	WetTurtle WetTurtle2 = new WetTurtle(600, 205, -1, 120, 120);
	WetTurtle WetTurtle3 = new WetTurtle(400, 205, -1, 120, 120);
	WetTurtle WetTurtle4 =new WetTurtle(200, 205, -1, 120, 120);

	Obstacle truck1 = new Obstacle(FILE_SRC_PICS + "truck1" +"Right.png", 0, 655, 1, 110, 110);
	Obstacle truck2 = new Obstacle(FILE_SRC_PICS + "truck1" +"Right.png", 300, 655, 1, 110, 110);
	Obstacle truck3 = new Obstacle(FILE_SRC_PICS + "truck1" +"Right.png", 600, 655, 1, 110, 110);
	Obstacle car1 = new Obstacle(FILE_SRC_PICS + "car1Left.png", 100, 605, -1, 50, 50);
	Obstacle car2 = new Obstacle(FILE_SRC_PICS + "car1Left.png", 250, 605, -1, 50, 50);
	Obstacle car3 = new Obstacle(FILE_SRC_PICS + "car1Left.png", 400, 605, -1, 50, 50);

	Obstacle truck4 = new Obstacle(FILE_SRC_PICS + "truck2Right.png", 0, 555, 1, 200, 200);
	Obstacle truck5 = new Obstacle(FILE_SRC_PICS + "truck2Right.png", 500, 555, 1, 200, 200);

	Obstacle quickcar1 = new Obstacle(FILE_SRC_PICS + "car1Left.png", 500, 505, -5, 50, 50);
	Obstacle quickcar2 = new Obstacle(FILE_SRC_PICS + "car1right.png", 500, 455, 4, 50, 50);

	Digit scoreOnes = new Digit(0, 30, 525, 35,'r');
	Digit scoreTens = new Digit(0, 30,525 - 23, 35,'r');
	Digit scoreHundreds = new Digit(0, 30,525 - 23 - 23, 35,'r');

	Digit lifeOnes = new Digit(3, 30, 75, 755,'r');
	Digit lifeTens = new Digit(0, 30, 50, 755,'r');

	Digit roundnumOnes = new Digit(1, 40, 340, 35,'w');

	ImageView pauseIcon = new ImageView(new Image(FILE_SRC_PICS + "pause-icon.png", 40, 40, true, true));


	@Override
	public void act(long now) {
		
	}
	
	public GameStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
		ImageView froggerback = new ImageView(new Image(FILE_SRC_PICS + "iKogsKW.png", 600, 800, true, true));
		getChildren().add(froggerback);

		pauseIcon.setOnMouseClicked(event -> pause());
		pauseIcon.setTranslateX(5);
		pauseIcon.setTranslateY(5);
		getChildren().add(pauseIcon);

		add(new Log(FILE_SRC_PICS + "log3.png", 135, 0, 160, 1));
		add(new Log(FILE_SRC_PICS + "log3.png", 135, 220, 160, 1));
		add(new Log(FILE_SRC_PICS + "log3.png", 135, 440, 160, 1));
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
		frog = new Animal(FILE_SRC_PICS + "froggerUp.png");
		add(frog);
		add(scoreOnes);
		add(scoreTens);
		add(scoreHundreds);
		add(lifeOnes);
		add(lifeTens);
		add(roundnumOnes);



		ImageView heart = new ImageView(new Image(FILE_SRC_PICS + "heart.png", 40, 40, true, true));
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
		String musicFile = "src/res/audios/Gaming.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
		mediaPlayer.setVolume(0.2);
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
					scores.add(frog.getPoints());
					setLifesNumber(frog.getLifes());
					STOP();
					stopMusic();
					String musicFile = "src/res/audios/GameOver.mp3";
					Media sound = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(sound);
					mediaPlayer.setCycleCount(1);
					mediaPlayer.play();
					mediaPlayer.setVolume(1.0);
					HighScoreBoard board = new HighScoreBoard(scores);
					board.setTranslateX(130);
					board.setTranslateY(200);
					getChildren().add(board);
					mediaPlayer.setOnEndOfMedia(new Runnable() {
						@Override
						public void run() {
							Platform.runLater(()->{
								popupResult();
								toMainMenu();
							});
						}
					});
				}

				if (frog.getStop()) {
					frog.resetEnd();
					scores.add(frog.getPoints());
					getChildren().remove(frog);
					stopMusic();
					String musicFile = "src/res/audios/Clear.mp3";
					Media sound = new Media(new File(musicFile).toURI().toString());
					mediaPlayer = new MediaPlayer(sound);
					mediaPlayer.setCycleCount(1);
					mediaPlayer.play();
					mediaPlayer.setVolume(0.2);
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

	public void pause(){
		STOP();
		mediaPlayer.pause();
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Paused!");
		alert.setHeaderText("Pause!");
		alert.setContentText("Quit or continue? (All your current process will be lost if you quit)");
		ButtonType buttonTypeOne = new ButtonType("Quit");
		ButtonType buttonTypeTwo = new ButtonType("Continue");

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
			toMainMenu();

		} else {
			start();
			mediaPlayer.play();
		}
	}

	public void popupResult(){
		int total_score = 0;
		int bonus = frog.getLifes()* 50;
		for(int i = 0; i<scores.size();i++){
			total_score += scores.get(i);
		}
		total_score += bonus;
		TextInputDialog inputDialog = new TextInputDialog("name");
		inputDialog.setTitle("Congratulation!");
		inputDialog.setHeaderText("Remaining life bonus:"+ bonus +"\nTotal score after bonus: "+total_score +"\nLet's see if you in the leaderboard!");
		inputDialog.setContentText("Enter your player name:");
		Optional<String> result = inputDialog.showAndWait();
		if (result.isPresent()) {
			LocalDateTime localDate = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			String date = dtf.format(localDate);

			leaderBoard = new LeaderBoard();
			leaderBoard.insertNewRecord(result.get(), date ,total_score);
		}
	}

	public void toMainMenu(){
		Scene mainScene = mainMenu.setupMainScene();
		primaryStage.setScene(mainScene);
	}

	public void setPointsNumber(int n) {
		int k = n % 10;
		n = n / 10;
		scoreOnes.changeImage(k);
		k = n % 10;
		n = n /10;
		scoreTens.changeImage(k);
		scoreHundreds.changeImage(n);
	}
	public void setLifesNumber(int n){
		lifeOnes.changeImage(n%10);
		lifeTens.changeImage(n/10);
	}


	public void setRoundNum(int n){
		roundnumOnes.changeImage(n % 10);
		if(n==10) {
			add(new Digit(1, 40, 313, 35, 'w'));
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
