package sample;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import data.*;

import java.io.File;

public class HomePageController {

    //liste des elements FXML utilises
    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private javafx.scene.control.Button newPage;
    @FXML
    private javafx.scene.control.Button loadPage;



    private SceneWorker work = new SceneWorker();

    @FXML
    private void closeButtonAction() {   // ferme la fenetre du jeu
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void goToNew() throws Exception {   //switch to newgameScene
            try {
                work.builder((Stage) newPage.getScene().getWindow(), "newGame_pag.fxml", "New-game", 400,400);
            }catch (Exception e){
                System.out.print("ah!");
            }
    }

    @FXML
    private void goToLoad() throws Exception {   //switch to loadgameScene
        FileChooser fileChooser = new FileChooser();
        File toOpen = fileChooser.showOpenDialog(loadPage.getScene().getWindow());
        SaverLoader sl = new SaverLoader(toOpen);
        try {
            GlobalController.setCurrentYear(sl.loadAnnee());
            // On change de scène si on a bien un fichier correct
            try {
                work.builder((Stage) loadPage.getScene().getWindow(), "MenuForPlay_page.fxml", "Tennis-en-pension",800,500);
            }catch (Exception e){
                System.out.print("ah!");
            }
        }catch (Exception e){

        }
    }

}
