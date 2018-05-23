package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class WinnerPageController {
    @FXML
    private javafx.scene.control.Label affiche;

    @FXML
    private javafx.scene.control.Button close;

    @FXML
    public void initialize(){
        affiche.setText(GlobalController.getTempWinner().getPrenom()+" "+GlobalController.getTempWinner().getNom());
    }

    @FXML
    private void closeButtonAction(){   // Function closing the  stage
        // get a handle to the stage
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
