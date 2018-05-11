package sample;

import data.SaverLoader;
import game.Joueur;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LoadGamePageController {
    @FXML
    private javafx.scene.control.Button goBack;

    @FXML
    private javafx.scene.control.TextField pathFile;

    @FXML
    private javafx.scene.control.Button importButton;

    private SceneWorker work = new SceneWorker();

    @FXML
    private void goToFirst() throws Exception { // function goback first scene
        try {
            work.builder((Stage) goBack.getScene().getWindow(), "home_page.fxml", "Tennis-en-pension");
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void takeURL() throws Exception {
        FileChooser fileChooser = new FileChooser();
        File toOpen = fileChooser.showOpenDialog(goBack.getScene().getWindow());
        SaverLoader sl = new SaverLoader(toOpen);
        ArrayList<Joueur> list = new ArrayList<>(Arrays.asList(sl.loadJoueurs()));
    }
}
