package main.LeaderBoard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.Main;
import main.MainMenu.MainMenu;

import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.ResourceBundle;

public class LeaderBoardController implements Initializable {
    MainMenu mainMenu= Main.mainMenu;
    LeaderBoard leaderBoard = new LeaderBoard();

    @FXML
    Label  name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11, name12, name13, name14, name15;
    @FXML
    Label score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, score11, score12, score13, score14, score15;
    @FXML
    Label date1, date2, date3, date4, date5, date6, date7, date8, date9, date10, date11, date12, date13, date14, date15;

    //private List<Label> labelList;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int numPlayer = leaderBoard.playerNames.length;

        name1.setText(leaderBoard.playerNames[0]);
        name2.setText(leaderBoard.playerNames[1]);
        name3.setText(leaderBoard.playerNames[2]);
        name4.setText(leaderBoard.playerNames[3]);
        name5.setText(leaderBoard.playerNames[4]);
        name6.setText(leaderBoard.playerNames[5]);
        name7.setText(leaderBoard.playerNames[6]);
        name8.setText(leaderBoard.playerNames[7]);
        name9.setText(leaderBoard.playerNames[8]);
        name10.setText(leaderBoard.playerNames[9]);
        name11.setText(leaderBoard.playerNames[10]);
        name12.setText(leaderBoard.playerNames[11]);
        name13.setText(leaderBoard.playerNames[12]);
        name14.setText(leaderBoard.playerNames[13]);
        name15.setText(leaderBoard.playerNames[14]);

        date1.setText(leaderBoard.dates[0]);
        date2.setText(leaderBoard.dates[1]);
        date3.setText(leaderBoard.dates[2]);
        date4.setText(leaderBoard.dates[3]);
        date5.setText(leaderBoard.dates[4]);
        date6.setText(leaderBoard.dates[5]);
        date7.setText(leaderBoard.dates[6]);
        date8.setText(leaderBoard.dates[7]);
        date9.setText(leaderBoard.dates[8]);
        date10.setText(leaderBoard.dates[9]);
        date11.setText(leaderBoard.dates[10]);
        date12.setText(leaderBoard.dates[11]);
        date13.setText(leaderBoard.dates[12]);
        date14.setText(leaderBoard.dates[13]);
        date15.setText(leaderBoard.dates[14]);

        score1.setText(leaderBoard.scores[0]);
        score2.setText(leaderBoard.scores[1]);
        score3.setText(leaderBoard.scores[2]);
        score4.setText(leaderBoard.scores[3]);
        score5.setText(leaderBoard.scores[4]);
        score6.setText(leaderBoard.scores[5]);
        score7.setText(leaderBoard.scores[6]);
        score8.setText(leaderBoard.scores[7]);
        score9.setText(leaderBoard.scores[8]);
        score10.setText(leaderBoard.scores[9]);
        score11.setText(leaderBoard.scores[10]);
        score12.setText(leaderBoard.scores[11]);
        score13.setText(leaderBoard.scores[12]);
        score14.setText(leaderBoard.scores[13]);
        score15.setText(leaderBoard.scores[14]);

//        for(int i =0;i<numPlayer; ) {
//           label.setText(leaderBoard.playerNames[i]);
//           i++;
//           if(i == numPlayer){
//               break;
//           }}
    }

    public void toMainMenu(ActionEvent event){
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene mainScene = mainMenu.setupMainScene();
        window.setScene(mainScene);
    }


}
