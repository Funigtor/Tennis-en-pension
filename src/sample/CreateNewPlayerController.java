package sample;

import data.Annee;
import game.Joueur;
import game.Sexe;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CreateNewPlayerController {
    //liste des elements FXML utilises
    @FXML
    private javafx.scene.control.Button menu;
    @FXML
    private javafx.scene.control.TextField name;
    @FXML
    private javafx.scene.control.TextField firstname;
    @FXML
    private javafx.scene.control.Label sex;
    @FXML
    private javafx.scene.control.Label nbJoueurs;

    //class qui permet de changer de fenetre
    private SceneWorker work = new SceneWorker();

    private Sexe type = GlobalController.sexe;

    private ArrayList<Joueur> myList = new ArrayList<>();

    @FXML
    private void goToFirst() throws Exception { // retourne  au menu de base du jeu
        try {
            GlobalController.setCurrentYear(new Annee(myList, type, GlobalController.nbAnnee));
            work.builder((Stage) menu.getScene().getWindow(), "MenuForPlay_page.fxml", "Tennis-en-pension", 800, 500);
        } catch (Exception e) {
            System.out.print("ah!");
        }
    }

    @FXML
    private void nextPlayer() throws Exception { // ve vers la fenetre de creation de joueur
        try {
            Joueur newPlayer = new Joueur(name.getText(), firstname.getText(), type);
            this.myList.add(newPlayer);
            nbJoueurs.setText(this.myList.size() + " / 128 joueurs");
            // On vide les champs après chaque entrée
            name.setText("");
            firstname.setText("");
        } catch (Exception e) {
            System.out.print("ah!");
        }
    }

    @FXML
    protected void initialize() { // initialise la fenetre avec certain parametre
        if (type == Sexe.MASCULIN)
            sex.setText("Masculin");
        else
            sex.setText("Féminin");
    }

}
