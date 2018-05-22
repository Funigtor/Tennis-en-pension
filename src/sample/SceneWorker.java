package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneWorker {
    public void builder(Stage newStage , String file, String name, int width, int height) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(file));
        newStage.setTitle(name);
        newStage.setScene(new Scene(root, width, height));
        newStage.show();
    }

    public void builder2(String file, String name, int width, int height) throws Exception{
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(file));
        newStage.setTitle(name);
        newStage.setScene(new Scene(root, width, height));
        newStage.show();
    }
}
