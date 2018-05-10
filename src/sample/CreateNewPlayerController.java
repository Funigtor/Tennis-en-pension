package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class CreateNewPlayerController {
    @FXML
    private javafx.scene.control.Button next;

    @FXML
    private javafx.scene.control.Button menu;

    private SceneWorker work = new SceneWorker();

    @FXML
    private void goToFirst() throws Exception { // function goback first scene
        try {
            work.builder((Stage) menu.getScene().getWindow(), "MenuForPlay_page.fxml", "Tennis-en-pension");
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void nextPlayer() throws Exception { // function goback first scene
        try {
            work.builder((Stage) next.getScene().getWindow(), "createNewPlayer_page.fxml", "create-player");
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

}
