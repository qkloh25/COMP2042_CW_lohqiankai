package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Actors.*;
import main.MainMenu.MainMenu;

public class Main extends Application {
	Scene mainScene;
	public static MainMenu mainMenu;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Frogger!");
		//Set up the scenes.
		mainMenu = new MainMenu(primaryStage);
		mainScene = mainMenu.setupMainScene();
		//Start the application.
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
}
