package main.MainMenu;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.World.GameStage;
import main.Main;

import java.io.File;

public class MainMenu extends Parent {
    GameStage gameStage;
    Scene gameScene;

    public MainMenu(Stage primaryStage){
        VBox menu0 = new VBox(25);
        VBox menu1 = new VBox(25);

        menu0.setTranslateX(170);
        menu0.setTranslateY(200);

        menu1.setTranslateX(170);
        menu1.setTranslateY(200);

        final int offset =400;

        MenuButton btnResume = new MenuButton("Start");
        btnResume.setOnMouseClicked(event ->{
            gameScene = setupGameScene(primaryStage);
            primaryStage.setScene(gameScene);
            gameStage.start();
            gameStage.playMusic();
//				FadeTransition ft = new FadeTransition(Duration.seconds(0.25),this);
//				ft.setFromValue();
        });

        MenuButton btnLeaderBoards = new MenuButton("LEADERBOARD");
        btnLeaderBoards.setOnMouseClicked(event ->{
            try {
                Scene leaderboard = loadLeaderBoard();
                primaryStage.setScene(leaderboard);

            } catch (Exception e) {
                e.printStackTrace();
            }

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

                MediaPlayer mediaPlayer = new MediaPlayer(sound);
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

    public Scene setupGameScene(Stage primaryStage){
        //GameScene Setup
        gameStage = new GameStage();
        return new Scene(gameStage,565,800);
    }

    public Scene loadLeaderBoard() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LeaderBoard/LeaderBoard.fxml"));

        return new Scene(root,565,800);

    }
}
