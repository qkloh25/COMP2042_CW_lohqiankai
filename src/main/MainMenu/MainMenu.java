package main.MainMenu;

import main.LeaderBoard.LeaderBoard;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Main;
import main.World.GameStage;


import java.io.File;

public class MainMenu extends Parent {
    public static final String FILE_SRC_AUDIOS = "src/res/audios/";
    public static final String FILE_SRC_PICS = "file:src/res/pics/";
    GameStage gameStage;
    Scene gameScene;
    MediaPlayer mediaPlayer;
    public MainMenu(Stage primaryStage){
        int offset = 500;
        ImageView logo = new ImageView(new Image(FILE_SRC_PICS + "frogger-logo.png", 300, 300, true, true));
        logo.setTranslateX(140);
        logo.setTranslateY(20);

        VBox menu0 = new VBox(10);
        menu0.setTranslateX(145);
        menu0.setTranslateY(250);

        VBox menu1 = new VBox(10);
        menu1.setTranslateX(0);
        menu1.setTranslateY(0);

        MenuButton btnGame = new MenuButton("Start");
        btnGame.setOnMouseClicked(event ->{
            gameStage = new GameStage(primaryStage);
            gameScene = gameStage.setupGameScene();
            primaryStage.setScene(gameScene);
            gameStage.start();
            gameStage.playMusic();
            stopMusic();
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
            getChildren().add(menu1);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25),menu0);
            tt.setToX(menu0.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5),menu1);
            tt1.setToX(35);

            tt.play();
            tt1.play();
            getChildren().remove(menu0);
        });

        MenuButton btnExit = new MenuButton("EXIT");
        btnExit.setOnMouseReleased(event -> System.exit(0));
        menu0.getChildren().addAll(btnGame,btnLeaderBoards,btnHowtoPlay,btnExit);

        MenuButton btnBack = new MenuButton("Back");
        btnBack.setOnMouseClicked(event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() - offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(145);


            tt.play();
            tt1.play();
            getChildren().remove(menu1);
        });

        StackPane InstructionView = new StackPane();
        Text instructions = new Text(50,50,"" +
                "1.There are totally 10 rounds.\n\n" +
                "2.Each round with 5 destinations.\n\n" +
                "3.Reach all 5 destinations, we proceed to the next round.\n\n" +
                "4.Reach a destination, u gain points and a life.\n\n" +
                "5.Die in water or car crash, you lose points and a life.\n\n" +
                "6.If your life become 0, it is GameOver.\n\n" +
                "7.Remaining lifes will turn into points at Round10.\n\n" +
                "8.Use the keys 'A' 'W' 'S' 'D' to move the frog.\n\n" +
                "9.Try your best to make your name on LEADERBOARD!\n\n" +
                "10.Good Luck and have Fun!");

        instructions.setFont(Font.loadFont(FILE_SRC_PICS + "Minecraft.ttf", 18));
        instructions.setFill(Color.WHITE);


        Rectangle bg = new Rectangle(500,500);
        bg.setOpacity(0.7);
        bg.setFill(Color.BLACK);
        bg.setEffect(new GaussianBlur(3.5));


        InstructionView.getChildren().addAll(bg,instructions);
        menu1.getChildren().addAll(btnBack,InstructionView);
//
//        Rectangle bg = new Rectangle(565,800);
//        bg.setFill(Color.GREY);
//        bg.setOpacity(0);

        getChildren().addAll(logo, menu0);

    }

    public class MenuButton extends StackPane {
        private Text text;

        public MenuButton(String name){
            text = new Text(name);
            text.setFont(Font.loadFont(FILE_SRC_PICS + "BACKTO1982.TTF", 25));
            text.setFill(Color.WHITE);

            Rectangle bg = new Rectangle(300,100);
            bg.setOpacity(0.5);
            bg.setFill(Color.BLACK);
            bg.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);


            setOnMouseEntered(event->{
                Media sound = new Media(new File(FILE_SRC_AUDIOS + "/Collect.wav").toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.setCycleCount(1);
                mediaPlayer.play();
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });
            setOnMousePressed(event ->{
                Media sound = new Media(new File(FILE_SRC_AUDIOS + "/mouseclick.mp3").toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.setCycleCount(1);
                mediaPlayer.play();
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


    public Scene loadLeaderBoard() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("LeaderBoard/LeaderBoard.fxml"));
        return new Scene(root,565,800);
    }

    public Scene setupMainScene(){
        Pane mainPage = new Pane();
        ImageView test = new ImageView(new Image(FILE_SRC_PICS + "original.gif", 565, 800, true, true));
        test.setFitHeight(800);
        test.setFitWidth(565);
        mainPage.getChildren().addAll(test, this);
        return new Scene(mainPage, 565,800);
    }

    public void playMusic() {
        String musicFile = FILE_SRC_AUDIOS + "maplestory.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.5);
    }
    public void stopMusic() {
        mediaPlayer.stop();
    }
}
