package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.Actors.*;
import main.World.GameStage;
import main.MainMenu.MainMenu;

public class Main extends Application {
	AnimationTimer timer;
	MediaPlayer mediaPlayer;
	GameStage gameStage;
	Animal animal;
	Scene mainScene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Frogger!");

		//Set up the scenes.
		mainScene = setupMainScene(primaryStage);
		//Start the application.
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public Scene setupMainScene(Stage primaryStage){
		MainMenu mainMenu = new MainMenu(primaryStage);
		Pane mainScene = new Pane();

		BackgroundImage mainImage = new BackgroundImage("file:src/pics/original.gif");
		mainImage.setFitHeight(800);
		mainImage.setFitWidth(565);
		mainScene.getChildren().addAll(mainImage, mainMenu);
		return new Scene(mainScene, 565,800);
	}




    

}
