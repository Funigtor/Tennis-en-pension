package sample;

import game.Joueur;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MenuforPlayController {
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private javafx.scene.control.Button morePlayer;

    @FXML
    private javafx.scene.control.Button exportListe;

    @FXML
    private javafx.scene.control.MenuItem MatchSolo;

    @FXML
    private javafx.scene.control.MenuItem TournoiMatch;

    @FXML
    private javafx.scene.control.MenuItem YearMatchs;

    private SceneWorker work = new SceneWorker();

    @FXML
    private void closeButtonAction(){   // Function closing the  stage
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void goToNewPlayer() throws Exception {   //switch to newgameScene
        try {
            work.builder((Stage) morePlayer.getScene().getWindow(), "createNewPlayer_page.fxml", "create-player",400,400);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }
}
