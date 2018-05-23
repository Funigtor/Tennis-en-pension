package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneWorker {
    // permet de remplacer la fenetre actuel par celle de file
    public void builder(Stage newStage, String file, String name, int width, int height) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(file));
        newStage.setTitle(name);
        newStage.setScene(new Scene(root, width, height));
        newStage.show();
        newStage.setResizable(false);
    }

    // ouvre une nouvelle fenetre
    public void builder2(String file, String name, int width, int height) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(file));
        newStage.setTitle(name);
        newStage.setScene(new Scene(root, width, height));
        newStage.show();
        newStage.setResizable(false);
    }
}
