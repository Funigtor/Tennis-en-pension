package sample;

import game.Joueur;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import data.*;

import java.util.ArrayList;

public class HomePageController {
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private javafx.scene.control.Button newPage;

    @FXML
    private javafx.scene.control.Button loadPage;

    private SceneWorker work = new SceneWorker();

    @FXML
    private void closeButtonAction(){   // Function closing the  stage
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void goToNew() throws Exception {   //switch to newgameScene
            try {
                work.builder((Stage) newPage.getScene().getWindow(), "loadGame_page.fxml", "charger-une-annee");
            }catch (Exception e){
                System.out.print("ah!");
            }
    }

    @FXML
    private void goToLoad() throws Exception {   //switch to newgameScene
        try {
            work.builder((Stage) loadPage.getScene().getWindow(), "newGame_pag.fxml", "nouveau-jeu");
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

}
