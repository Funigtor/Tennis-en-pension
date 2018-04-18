package sample;
import game.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class NewGamePagController {
    //TODO
    Joueur test = new Joueur("tom","Duthoit", Sexe.MASCULIN);

    @FXML
    private javafx.scene.control.Button testJoueur;

    @FXML
    private void testJB() throws Exception {
        try {
            System.out.println("nom: "+test.getNom()+" | Prenom: "+ test.getPrenom()+" | puissance:"+ test.getPuissance());
        }catch (Exception e){
            System.out.print("ah!");
        }
    }
}
