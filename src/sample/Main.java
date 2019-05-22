package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.storage.Storage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Storage.seed();
        Parent root = FXMLLoader.load(getClass().getResource("Layouts/LoginPage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}