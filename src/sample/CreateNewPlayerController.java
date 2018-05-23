package sample;

import data.Annee;
import game.Joueur;
import game.Sexe;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CreateNewPlayerController {
    @FXML
    private javafx.scene.control.Button next;

    @FXML
    private javafx.scene.control.Button menu;

    @FXML
    private javafx.scene.control.TextField name;

    @FXML
    private javafx.scene.control.TextField firstname;

    @FXML
    private javafx.scene.control.Button affiche;

    @FXML
    private javafx.scene.control.Label sex;

    @FXML
    private javafx.scene.control.Label nbJoueurs;


    private SceneWorker work = new SceneWorker();

    private Sexe type = GlobalController.sexe;

    private ArrayList<Joueur> myList = new ArrayList<>();

    @FXML
    private void goToFirst() throws Exception { // function goback first scene
        try {
            GlobalController.setCurrentYear(new Annee(myList,type,GlobalController.nbAnnee));
            work.builder((Stage) menu.getScene().getWindow(), "MenuForPlay_page.fxml", "Tennis-en-pension",800,500);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void nextPlayer() throws Exception { // function goback first scene
        try {
            Joueur newPlayer = new Joueur(name.getText(),firstname.getText(),type);
            this.myList.add(newPlayer);
            nbJoueurs.setText(this.myList.size() + " / 128 joueurs");
            // On vide les champs après chaque entrée
            name.setText("");
            firstname.setText("");
        }catch (Exception e){
            System.out.print("ah!");
        }
    }


    @FXML
    private void affichage() throws Exception{
        try {
            for (Joueur m: myList) {
                System.out.println(m.getNom()+" - "+m.getPrenom()+" - "+ m.getSexe());
            }
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    protected void initialize(){
        if (type == Sexe.MASCULIN)
            sex.setText("Masculin");
        else
            sex.setText("Féminin");
    }

}
