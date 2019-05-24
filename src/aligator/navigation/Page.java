package aligator.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class Page {
    protected String name;
    protected String layout;

Page(String name, String layoutAddress){
    this.name = name;
    this.layout = layoutAddress;
}

    public Scene createNew(){
        Parent p;
        try {
            p = FXMLLoader.load(getClass().getResource(layout));
        } catch (IOException e){
            p = new VBox();
        }
        return new Scene(p);
    }

    public Boolean nameEquals(String name){
        return this.name.equals(name);
    }
}
