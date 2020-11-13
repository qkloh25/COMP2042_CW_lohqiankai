package main;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Actors.*;
import main.Backend.MyStage;

import java.io.File;

public class Main extends Application {
	AnimationTimer timer;
	MediaPlayer mediaPlayer;
	MyStage background;
	Animal animal;
	Scene mainMenu, gameScene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Frogger!");

		//Set up the scenes.
		mainMenu = setupMainScene(primaryStage);
		gameScene = setupGameScene(primaryStage);

		//Start the application.
		primaryStage.setScene(mainMenu);

		primaryStage.show();
	}

	public Scene setupMainScene(Stage primaryStage){
		GameMenu menu = new GameMenu(primaryStage);
		Pane mainmenu = new Pane();

		BackgroundImage mainImage = new BackgroundImage("file:src/pics/original.gif");
		mainImage.setFitHeight(800);
		mainImage.setFitWidth(565);

		mainmenu.getChildren().addAll(mainImage, menu);
		return new Scene(mainmenu, 565,800);
	}


	public Scene setupGameScene(Stage primaryStage){
		//GameScene Setup
		background = new MyStage();
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
		BackgroundImage froggerback = new BackgroundImage("file:src/pics/iKogsKW.png");
		background.add(froggerback);
		background.add(new Log("file:src/pics/log3.png", 135, 0, 160, 0.75));
		background.add(new Log("file:src/pics/log3.png", 135, 220, 160, 0.75));
		background.add(new Log("file:src/pics/log3.png", 135, 440, 160, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/pics/logs.png", 270, 0, 260, -2));
		background.add(new Log("file:src/pics/logs.png", 270, 400, 260, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/pics/log3.png", 135, 50, 305, 0.75));
		background.add(new Log("file:src/pics/log3.png", 135, 270, 305, 0.75));
		background.add(new Log("file:src/pics/log3.png", 135, 490, 305, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
		background.add(new Turtle(500, 350, -1, 120, 120));
		background.add(new Turtle(300, 350, -1, 120, 120));
		background.add(new WetTurtle(700, 350, -1, 120, 120));
		background.add(new WetTurtle(600, 205, -1, 120, 120));
		background.add(new WetTurtle(400, 205, -1, 120, 120));
		background.add(new WetTurtle(200, 205, -1, 120, 120));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		background.add(new End(11,96));
		background.add(new End(11 + 120,96));
		background.add(new End(11 + 120 + 120,96));
		background.add(new End(11 + 120 + 120 + 120,96));
		background.add(new End(11 + 120 + 120 + 120 + 120,96));
		animal = new Animal("file:src/pics/froggerUp.png");
		background.add(animal);
		background.add(new Obstacle("file:src/pics/truck1"+"Right.png", 0, 655, 1, 110, 110));
		background.add(new Obstacle("file:src/pics/truck1"+"Right.png", 300, 655, 1, 110, 110));
		background.add(new Obstacle("file:src/pics/truck1"+"Right.png", 600, 655, 1, 110, 110));
		//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/pics/car1Left.png", 100, 605, -1, 50, 50));
		background.add(new Obstacle("file:src/pics/car1Left.png", 250, 605, -1, 50, 50));
		background.add(new Obstacle("file:src/pics/car1Left.png", 400, 605, -1, 50, 50));
		background.add(new Obstacle("file:src/pics/car1Left.png", 550, 605, -1, 50, 50));
		background.add(new Obstacle("file:src/pics/truck2Right.png", 0, 555, 1, 200, 200));
		background.add(new Obstacle("file:src/pics/truck2Right.png", 500, 555, 1, 200, 200));
		background.add(new Obstacle("file:src/pics/car1Left.png", 500, 505, -10, 50, 50));
		background.add(new Obstacle("file:src/pics/car1right.png", 500, 455, 4, 50, 50));
		background.add(new Digit(0, 30, 360, 25));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);

		return new Scene(background,565,800);
	}

	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
    public class MenuButton extends StackPane {
		private Text text;

		public MenuButton(String name){
			text = new Text(name);
			text.setFont(text.getFont().font(30));
			text.setFill(Color.WHITE);

			Rectangle bg = new Rectangle(250,100);
			bg.setOpacity(0.5);
			bg.setFill(Color.BLACK);
			bg.setEffect(new GaussianBlur(3.5));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);


			setOnMouseEntered(event->{
				Media sound = new Media(new File("src/audios/Collect.wav").toURI().toString());
				mediaPlayer = new MediaPlayer(sound);
				mediaPlayer.setCycleCount(1);
				mediaPlayer.play();
				bg.setFill(Color.WHITE);
				text.setFill(Color.BLACK);
			});

			setOnMouseExited(event->{
				bg.setFill(Color.BLACK);
				text.setFill(Color.WHITE);
			});

			DropShadow drop = new DropShadow(50,Color.WHITE);
			drop.setInput(new Glow());
			setOnMousePressed(event -> setEffect(drop));
			setOnMouseReleased(event -> setEffect(null));
		}
	}
	private class GameMenu extends Parent {
		public GameMenu(Stage primaryStage){
			VBox menu0 = new VBox(25);
			VBox menu1 = new VBox(25);

			menu0.setTranslateX(170);
			menu0.setTranslateY(200);

			menu1.setTranslateX(170);
			menu1.setTranslateY(200);

			final int offset =400;

			MenuButton btnResume = new MenuButton("Start");
			btnResume.setOnMouseClicked(event ->{
				primaryStage.setScene(gameScene);
				background.start();
				start();
//				FadeTransition ft = new FadeTransition(Duration.seconds(0.25),this);
//				ft.setFromValue();
			});

			MenuButton btnLeaderBoards = new MenuButton("LEADERBOARD");
			btnLeaderBoards.setOnMouseClicked(event ->{

			});
			MenuButton btnHowtoPlay = new MenuButton("HOW TO PLAY");
			btnHowtoPlay.setOnMouseClicked(event ->{

			});

			MenuButton btnExit = new MenuButton("EXIT");
			btnExit.setOnMouseReleased(event -> System.exit(0));

			menu0.getChildren().addAll(btnResume,btnLeaderBoards,btnHowtoPlay,btnExit);

			Rectangle bg = new Rectangle(565,800);
			bg.setFill(Color.GREY);
			bg.setOpacity(0.4);

			getChildren().addAll(bg, menu0);

		}
	}
}
