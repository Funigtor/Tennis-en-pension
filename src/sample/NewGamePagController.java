package sample;
import com.sun.xml.internal.bind.v2.TODO;
import game.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class NewGamePagController {

    @FXML
    private javafx.scene.control.Button oneByOne;

    @FXML
    private javafx.scene.control.Button randCreat;

    private SceneWorker work = new SceneWorker();

    @FXML
    private void nextPlayer() throws Exception { // function goback first scene
        try {
            work.builder((Stage) oneByOne.getScene().getWindow(), "createNewPlayer_page.fxml", "create-player");
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void randomCreatF() throws Exception{
        try {
            work.builder((Stage) randCreat.getScene().getWindow(), "MenuForPlay_page.fxml", "Tennis-en-pension");
            // TODO creer les joueur ramdom
        }catch (Exception e){
            System.out.print("ah!");
        }
    }






}
