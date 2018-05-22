package sample;

import data.SaverLoader;
import game.*;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class NewGamePagController {

    @FXML
    private javafx.scene.control.Button oneByOne;

    @FXML
    private javafx.scene.control.Button randCreat;

    @FXML
    private javafx.scene.control.Button loadList;

    @FXML
    private javafx.scene.control.Button back;

    @FXML
    private javafx.scene.control.TextField date;

    @FXML
    private javafx.scene.control.Button tonext_willbeDell;

    @FXML
    private javafx.scene.control.Label erreur;

    private SceneWorker work = new SceneWorker();

    public GlobalController control = new GlobalController();

    @FXML
    private void nextPlayer() throws Exception { // function goback first scene
        try {
            work.builder((Stage) oneByOne.getScene().getWindow(), "createNewPlayer_page.fxml", "create-player",400,400);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void randomCreatF() throws Exception{
        try {
            //TODO
            work.builder((Stage) randCreat.getScene().getWindow(), "MenuForPlay_page.fxml", "Tennis-en-pension",800,500);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void goBack() throws Exception{
        try {
            work.builder((Stage) back.getScene().getWindow(), "home_page.fxml", "Tennis-en-pension",400,400);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void loadListe() throws Exception{
        try {
            //TODO
            FileChooser fileChooser = new FileChooser();
            File toOpen = fileChooser.showOpenDialog(loadList.getScene().getWindow());
            SaverLoader sl = new SaverLoader(toOpen);
            ArrayList<Joueur> list = new ArrayList<>(Arrays.asList(sl.loadJoueurs()));
            control.setMyList(list);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void setYear() throws Exception{
        try{
            control.Annee= Integer.parseInt(date.getText());
            System.out.println(control.Annee);
            erreur.setText("année valide");
        }catch (Exception e){
            erreur.setText("Mauvaise date");
        }
    }
}
