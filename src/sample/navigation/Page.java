package sample.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class Page {
    private String name;
    private Boolean recyclable;
    private String layout;

Page(String name, String layoutAddress, Boolean recyclable){
    this.name = name;
    this.layout = layoutAddress;
    this.recyclable = recyclable;
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

    public Boolean getRecyclable() {
        return recyclable;
    }

    public Boolean nameEquals(String name){
        return this.name.equals(name);
    }
}
