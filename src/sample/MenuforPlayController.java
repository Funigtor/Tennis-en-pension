package sample;

import game.*;
import data.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class MenuforPlayController {
    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private javafx.scene.control.Button exportListe;
    @FXML
    private javafx.scene.control.Button RolandGarros;
    @FXML
    private javafx.scene.control.Button USOpen;
    @FXML
    private javafx.scene.control.Button Wimbledon;
    @FXML
    private javafx.scene.control.Button IndianWells;
    @FXML
    private javafx.scene.control.Button Miami;
    @FXML
    private javafx.scene.control.Button OpenAustralie;
    @FXML
    private javafx.scene.control.Button YearMatchs;
    @FXML
    private javafx.scene.control.TableView tableau;
    @FXML
    private javafx.scene.control.TableColumn nom;
    @FXML
    private javafx.scene.control.TableColumn prenom;
    @FXML
    private javafx.scene.control.TableColumn classement;
    @FXML
    private javafx.scene.control.TableColumn score;
    @FXML
    private javafx.scene.control.Label titre;

    private SceneWorker work = new SceneWorker();

    private List<Joueur> participants;

    private boolean canStartTournaments;

    @FXML
    private void closeButtonAction(){   // Function closing the  stage
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        this.participants = GlobalController.getCurrentYear().getParticipants();
        canStartTournaments = (this.participants.size() == 128) ? true : false;
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        classement.setCellValueFactory(new PropertyValueFactory<>("classement"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        GlobalController.currentYear.getClassment().updateClassement();
        tableau.getItems().addAll(GlobalController.getCurrentYear().getParticipants());
        titre.setText("Annee "+GlobalController.currentYear.getAnnee());
    }

    @FXML
    private void jouerMatch() throws Exception{          //Lance un match entre deux joueurs aleatoires
        int rand1 =(int)(Math.random() * participants.size());
        int rand2 =(int)(Math.random() * participants.size());
        while (rand2==rand1){
            rand2 =(int)(Math.random() * participants.size());
        }
        Match jouons = new Match(participants.get(rand1),participants.get(rand2));
        jouons.jouerMatch();
        GlobalController.currentYear.getClassment().updateClassement();
        tableau.getItems().clear();
        tableau.getItems().addAll(participants);
        GlobalController.setTempWinner(jouons.getVainqueur());
        try{
            work.builder2("Winner_page.fxml","le Gagnant",400,200);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void sauvegarder() {
        FileChooser fileChooser = new FileChooser();
        File toOpen = fileChooser.showSaveDialog(exportListe.getScene().getWindow());
        SaverLoader sl = new SaverLoader(toOpen);
        sl.saveAnnee(GlobalController.getCurrentYear());
    }

    @FXML
    private void selectPlayer(){
        GlobalController.joueurAVoir = null;
        for (int i = 0; i < this.participants.size(); i++)
            if (tableau.getFocusModel().isFocused(i))
                GlobalController.joueurAVoir = this.participants.get(i);
        if (GlobalController.joueurAVoir != null)
            try {
                work.builder2("Player_page.fxml","Detail du joueur",400,550);
            } catch (Exception e){
                e.printStackTrace();
            }
    }

    @FXML
    private void historiqueMatch() throws Exception {   //switch to newgameScene
        try {
            work.builder2( "historique_page.fxml", "historique des tournois",400,400);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void jouerLAn() throws Exception{
        GlobalController.currentYear.jouerAnnee();
        RolandGarros.setCancelButton(true);
        GlobalController.currentYear.getClassment().updateClassement();
        tableau.getItems().clear();
        tableau.getItems().addAll(participants);
    }

    @FXML
    private void tournois1() throws Exception{

    }
}
