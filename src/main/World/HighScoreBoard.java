package main.World;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import main.Actors.Digit;

import java.util.*;

public class HighScoreBoard extends Pane {
    public HighScoreBoard(ArrayList<Integer> originalscores){
        int num_round = originalscores.size();
        ArrayList<Integer> scores =  new ArrayList<>();
        ImageView black_background = new ImageView(new Image("file:src/pics/black_background.png", 310, 500, true, true));
        ArrayList<Integer> roundnumber = new ArrayList<>();
        getChildren().add(black_background);

        for(int i = 0; i< num_round;i++){
            roundnumber.add(i+1);
            scores.add(originalscores.get(i));
        }
        //sort the round and their score.
        for(int i=0;i < num_round-1; i++){
            for(int j=0; j<num_round-i-1;j++){
                if(scores.get(j) < scores.get(j+1)){
                    Collections.swap(scores, j, j+1);
                    Collections.swap(roundnumber, j, j+1);
                }

            }
        }
        for(int i =0; i< num_round; i++) {
            Pane bar = new Pane();
            bar.setTranslateY(5+22*i);
            round example = new round("file:src/pics/Round.png",90,11,4);
            getChildren().add(bar);
            bar.getChildren().add(example);
            int shift = 0;
            int temp = roundnumber.get(i);
            while (temp > 0) {
                int d = temp  / 10;
                int k = temp - d * 10;
                temp = d;
                bar.getChildren().add(new Digit(k, 25, 110 - shift, 0,'w'));
                shift+=20;
            }
            shift = 0;

            while (scores.get(i) > 0) {

                int d = scores.get(i) / 10;
                int k = scores.get(i) - d * 10;
                scores.set(i,d);
                bar.getChildren().add(new Digit(k, 25, 280 - shift, 0,'g'));
                shift+=20;
            }
            if(roundnumber.get(i)== num_round){
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.2), bar);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.setCycleCount(Animation.INDEFINITE);
                fadeTransition.play();
            }
        }
    }
}
class round extends ImageView{
    public round(String imageLink, int size, int xpos, int ypos){
        setImage(new Image(imageLink, size,size, true, true));
        setX(xpos);
        setY(ypos);
    }
}