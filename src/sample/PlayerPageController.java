package sample;

import game.Joueur;
import game.Sexe;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;

public class PlayerPageController {
    @FXML
    private javafx.scene.chart.LineChart tabPoints;

    @FXML
    private javafx.scene.chart.LineChart tabRangs;

    @FXML
    private javafx.scene.control.Label name;

    @FXML
    private javafx.scene.control.Label sexe;

    @FXML
    private javafx.scene.control.Label puissance;

    @FXML
    private javafx.scene.control.Label endurance;

    @FXML
    protected void initialize(){
        Joueur player = GlobalController.joueurAVoir;
        name.setText(player.getNom() + " " + player.getPrenom());
        sexe.setText((player.getSexe() == Sexe.MASCULIN) ? "Masculin" : "Féminin");
        puissance.setText("Puissance : " + player.getPuissance());
        endurance.setText("Endurance : " + player.getEnduranceMax());
        XYChart.Series<String,Number> series = new XYChart.Series<>();;
        for (int i = 0;  i < player.getPoints().size(); i++){
            series.getData().add(new XYChart.Data<>(new Integer(i).toString(),player.getPoints().get(i)));
        }
        tabPoints.getData().add(series);
        if (player.getCurrentRang() == 1)
            tabRangs.setTitle("Winner winner chicken dinner");
        XYChart.Series<String,Number> ranks = new XYChart.Series<>();
        // On refait la même chose pour les rangs
        for (int i = 0;  i < player.getRang().size(); i++){
            ranks.getData().add(new XYChart.Data<>(new Integer(i).toString(),player.getRang().get(i)));
        }
        tabRangs.getData().add(ranks);
    }
}
