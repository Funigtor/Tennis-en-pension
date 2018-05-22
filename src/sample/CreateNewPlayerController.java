package sample;

import game.Joueur;
import game.Sexe;
import javafx.fxml.FXML;
import javafx.stage.Stage;

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


    private SceneWorker work = new SceneWorker();

    public GlobalController control = new GlobalController();

    private Sexe type = GlobalController.sexe;

    @FXML
    private void goToFirst() throws Exception { // function goback first scene
        try {
            work.builder((Stage) menu.getScene().getWindow(), "MenuForPlay_page.fxml", "Tennis-en-pension",400,400);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void nextPlayer() throws Exception { // function goback first scene
        try {
            work.builder((Stage) next.getScene().getWindow(), "createNewPlayer_page.fxml", "create-player",400,400);
            Joueur newPlayer = new Joueur(name.getText(),firstname.getText(),type);
            control.MyList.add(newPlayer);
        }catch (Exception e){
            System.out.print("ah!");
        }
    }


    @FXML
    private void affichage() throws Exception{
        try {
            for (Joueur m: GlobalController.MyList) {
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
