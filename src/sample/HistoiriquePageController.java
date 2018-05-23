package sample;

import data.*;
import game.MatchHistory;
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
    private javafx.scene.control.TableColumn j1;

    @FXML
    private javafx.scene.control.TableColumn j2;

    @FXML
    public void initialize(){
        tableTour.setCellValueFactory(new PropertyValueFactory<>("type"));
        for (Tournoi m: GlobalController.currentYear.getTournaments()) {
            tournois.getItems().add(m);
        }
    }

    @FXML
    private void afficheMatchs() throws Exception{

    }

    @FXML
    private void closeButtonAction(){   // Function closing the  stage
        // get a handle to the stage
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
