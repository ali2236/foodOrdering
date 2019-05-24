package aligator.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DynamicPage extends Page {

    private Object object;

    DynamicPage(String name, String layoutAddress) {
        super(name, layoutAddress);
    }

    public Scene createNew(){
        Parent p;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(layout));
            p = loader.load();
            IDynamicPage controller = loader.getController();
            controller.setObject(object);
        } catch (IOException e){
            p = new VBox();
        }
        return new Scene(p);
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
