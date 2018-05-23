package sample;

import data.Annee;
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
    private javafx.scene.control.Label erreur;

    @FXML
    private javafx.scene.control.RadioButton masculin;

    private int nbAnnee = 1;

    private SceneWorker work = new SceneWorker();

    @FXML
    private void nextPlayer() throws Exception { // function goback first scene
        try {
            GlobalController.sexe = (masculin.isSelected()) ? Sexe.MASCULIN : Sexe.FEMININ;
            work.builder((Stage) oneByOne.getScene().getWindow(), "createNewPlayer_page.fxml", "create-player",400,400);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void randomCreatF() throws Exception{
        try {
            ArrayList<Joueur> randPlayers = new ArrayList<>();
            Sexe selectedSex = (masculin.isSelected()) ? Sexe.MASCULIN : Sexe.FEMININ;
            for (int i = 0;i < 128; i++)
                randPlayers.add(new Joueur(selectedSex));
            GlobalController.setCurrentYear(new Annee(randPlayers,selectedSex,nbAnnee));
            work.builder((Stage) randCreat.getScene().getWindow(), "MenuForPlay_page.fxml", "Menu",800,500);
        }catch (Exception e){
            e.printStackTrace();
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
            FileChooser fileChooser = new FileChooser();
            File toOpen = fileChooser.showOpenDialog(loadList.getScene().getWindow());
            SaverLoader sl = new SaverLoader(toOpen);
            // On regarde le sexe choisi
            Sexe selectedSex = (masculin.isSelected()) ? Sexe.MASCULIN : Sexe.FEMININ;
            ArrayList<Joueur> list = sl.loadJoueurs(selectedSex);
            // Après chargement on va créer l'année et changer de scène
            GlobalController.setCurrentYear(new Annee(list,selectedSex,nbAnnee));
            work.builder((Stage) back.getScene().getWindow(), "MenuForPlay_page.fxml", "Tennis-en-pension",800,500);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void setYear() throws Exception{
        try{
            nbAnnee = Integer.parseInt(date.getText());
            GlobalController.nbAnnee = nbAnnee;
            erreur.setText("année valide");
        }catch (Exception e){
            erreur.setText("Mauvaise date");
        }
    }
}
