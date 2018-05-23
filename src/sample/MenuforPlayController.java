package sample;

import game.Joueur;
import game.Match;
import game.Sexe;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MenuforPlayController {
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private javafx.scene.control.Button morePlayer;

    /*
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
    private javafx.scene.control.Button MatchSolo;
    */

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

    private SceneWorker work = new SceneWorker();

    //temporaire
    private ArrayList<Joueur> tebJ= new ArrayList<>();

    private List<Joueur> participants;

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
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        classement.setCellValueFactory(new PropertyValueFactory<>("classement"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        tableau.getItems().clear();
        tableau.getItems().addAll(GlobalController.getCurrentYear().getParticipants());
    }

    @FXML
    private void jouerMatch(){          //Lance un match entre deux joueurs aleatoires
        Match jouons = new Match(participants.get((int)(Math.random() * participants.size())),
                participants.get((int)(Math.random() * participants.size())));
        tableau.getItems().clear();
        tableau.getItems().addAll(participants);
    }



    //FONCTIONs TEMPORAIRES
    @FXML
    private void testTabView() throws Exception{
        try {
            Joueur test = new Joueur(Sexe.MASCULIN);
            tableau.getItems().add(test);
            tebJ.add(test);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void tessupdate() throws Exception{
        try {
            for(int i = 0; i<tebJ.size()-1;i++){
                Match joujou = new Match(tebJ.get(i),tebJ.get(i+1));
                joujou.jouerMatch();
                tableau.getItems().clear();
                tableau.getItems().addAll(tebJ);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void testNewWind() throws Exception {   //switch to newgameScene
        try {
            work.builder2( "historique_page.fxml", "historique des tournois",400,400);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }
}
