package sample.navigation;

import com.sun.javafx.stage.StageHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.storage.SceneManager;

import java.io.IOException;

public class Page {
    public AppPages type;
    public Boolean recyclable;
    private String layout;

    public Scene createNew(){
        Parent p;
        try {
            p = FXMLLoader.load(getClass().getResource(layout));
        } catch (IOException e){
            p = new VBox();
        }
        return new Scene(p);
    }

}
