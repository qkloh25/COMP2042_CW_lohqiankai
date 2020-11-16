package main.LeaderBoard;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.EventObject;

public class LeaderBoardController {

    public void toMainMenu(ActionEvent event){

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


    }

}
