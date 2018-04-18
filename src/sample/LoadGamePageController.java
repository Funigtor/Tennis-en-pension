package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class LoadGamePageController {
    @FXML
    private javafx.scene.control.Button goBack;

    @FXML
    private javafx.scene.control.TextField pathFile;

    @FXML
    private javafx.scene.control.Button importButton;

    private SceneWorker work = new SceneWorker();

    @FXML
    private void goToFirst() throws Exception { // function goback first scene
        try {
            work.builder((Stage) goBack.getScene().getWindow(), "home_page.fxml", "Tennis-en-pension");
        }catch (Exception e){
            System.out.print("ah!");
        }
    }

    @FXML
    private void takeURL() throws Exception {
        try {
            String test = pathFile.getText();
            System.out.println(test+" : url envoyer");
            work.builder((Stage) importButton.getScene().getWindow(), "home_page.fxml", "Tennis-en-pension");
        }catch (Exception e){
            System.out.print("ah!");
        }
    }
}
