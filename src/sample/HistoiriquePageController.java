package sample;

import data.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HistoiriquePageController {
    @FXML
    private javafx.scene.control.Button close;

    @FXML
    private javafx.scene.control.TableView tournois;

    @FXML
    private javafx.scene.control.TableColumn tableTour;

    @FXML
    private javafx.scene.control.TableView matchListe;

    @FXML
    private javafx.scene.control.TableColumn Matchs;

    @FXML
    public void initialize(){
        tableTour.setCellValueFactory(new PropertyValueFactory<>("type"));
        for (Tournoi m: GlobalController.currentYear.getTournaments()) {
            tournois.getItems().add(m);
        }
    }


    @FXML
    private void closeButtonAction(){   // Function closing the  stage
        // get a handle to the stage
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
