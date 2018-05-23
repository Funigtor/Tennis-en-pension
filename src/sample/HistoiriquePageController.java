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
    private javafx.scene.control.TableColumn matchs;

    @FXML
    public void initialize(){
        tableTour.setCellValueFactory(new PropertyValueFactory<>("type"));
        matchs.setCellValueFactory(new PropertyValueFactory<>("nom"));
        for (Tournoi m: GlobalController.currentYear.getTournaments()) {
            tournois.getItems().add(m);
        }
    }

    @FXML
    private void afficheMatchs() throws Exception{
        GlobalController.tournoiAVoir = null;
        for (int i = 0; i < GlobalController.currentYear.getTournaments().size(); i++)
            if (tournois.getFocusModel().isFocused(i))
                GlobalController.tournoiAVoir = GlobalController.currentYear.getTournaments().get(i);
        if (GlobalController.joueurAVoir != null)
            try {
                tournois.getItems().addAll(GlobalController.tournoiAVoir.getMatches());
            } catch (Exception e){
                e.printStackTrace();
            }
    }

    @FXML
    private void closeButtonAction(){   // Function closing the  stage
        // get a handle to the stage
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
