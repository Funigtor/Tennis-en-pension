package sample;

import game.MatchHistory;
import javafx.fxml.FXML;

public class SetMatchHistController {

    @FXML
    private javafx.scene.control.Label joueurA;

    @FXML
    private javafx.scene.control.Label joueurB;

    private MatchHistory match = GlobalController.matchAVoir;

    @FXML
    protected void initialize(){
        joueurA.setText(match.getJoueurA().getNom() + " " + match.getJoueurA().getPrenom());
        joueurB.setText(match.getJoueurB().getNom() + " " + match.getJoueurB().getPrenom());
    }
}
