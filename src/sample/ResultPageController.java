package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ResultPageController {
    @FXML
    private javafx.scene.control.Button menuBoutton;

    @FXML
    private javafx.scene.control.Label resultText;

    private SceneWorker work = new SceneWorker();

    @FXML
    private void goToFirst() throws Exception { // function goback first scene
        try {
            work.builder((Stage) menuBoutton.getScene().getWindow(), "MenuForPlay_page.fxml", "Tennis-en-pension");
        }catch (Exception e){
            System.out.print("ah!");
        }
    }
}
