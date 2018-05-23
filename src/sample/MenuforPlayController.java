package sample;

import game.*;
import data.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MenuforPlayController {
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private javafx.scene.control.Button morePlayer;

    @FXML
    private javafx.scene.control.Button exportListe;

    @FXML
    public javafx.scene.control.TableView tableau;

    @FXML
    public javafx.scene.control.TableColumn nom;

    @FXML
    public javafx.scene.control.TableColumn prenom;

    @FXML
    public javafx.scene.control.TableColumn classement;

    @FXML
    public javafx.scene.control.TableColumn score;

    @FXML
    public javafx.scene.control.Label titre;

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
    private void goToNewPlayer() throws Exception {   //switch to newgameScene
        try {
            work.builder((Stage) morePlayer.getScene().getWindow(), "createNewPlayer_page.fxml", "create-player",400,400);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    public void initialize() {
        this.participants = GlobalController.getCurrentYear().getParticipants();
        canStartTournaments = (this.participants.size() == 128) ? true : false;
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        classement.setCellValueFactory(new PropertyValueFactory<>("classement"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        tableau.getItems().clear();
        tableau.getItems().addAll(GlobalController.getCurrentYear().getParticipants());
        titre.setText("Annee "+GlobalController.currentYear.getAnnee());
    }

    @FXML
    private void jouerMatch() throws Exception{          //Lance un match entre deux joueurs aleatoires
        Match jouons = new Match(participants.get((int)(Math.random() * participants.size())),
                participants.get((int)(Math.random() * participants.size())));
        jouons.jouerMatch();
        System.out.println(jouons.getVainqueur().getScore());
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

    //FONCTIONs TEMPORAIRES
    @FXML
    private void testNewWind() throws Exception {   //switch to newgameScene
        try {
            work.builder2( "historique_page.fxml", "historique des tournois",400,400);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }
}
