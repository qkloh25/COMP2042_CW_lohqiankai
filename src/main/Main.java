package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.MainMenu.MainMenu;

/**
 * The main activity.
 */
public class Main extends Application {
	Scene mainScene;
	public static MainMenu mainMenu;

	/**
	 * To prepare the start.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Start the game.
	 * @param primaryStage The game stage.
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Frogger!");
		//Set up the scenes.
		mainMenu = new MainMenu(primaryStage);
		mainScene = mainMenu.setupMainScene();
		//Start the application.
		primaryStage.setScene(mainScene);
		primaryStage.setResizable(false);
		mainMenu.playMusic();
		primaryStage.show();
	}
}
