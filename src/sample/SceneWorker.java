package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneWorker {
    public void builder(Stage newStage , String file, String name) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(file));
        newStage.setTitle(name);
        newStage.setScene(new Scene(root, 600, 600));
        newStage.show();
    }
}
