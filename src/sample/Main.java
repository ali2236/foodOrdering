package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.models.Food;
import sample.models.Restaurant;
import sample.navigation.INavigation;
import sample.navigation.Navigation;
import sample.storage.Storage;

import java.util.Arrays;

public class Main extends Application implements INavigation {

    @Override
    public void start(Stage primaryStage){
        seed();
        addPrimaryStage(primaryStage);
        addPages();
        Navigation.to("main");
    }

    @Override
    public void addPrimaryStage(Stage primaryStage) {
        Navigation.setPrimaryStage(primaryStage);
    }

    @Override
    public void addPages() {
        final String BaseAddress = "../Layouts/";
        Navigation.addPage("login",BaseAddress + "page_login.fxml",false);
        Navigation.addPage("signup",BaseAddress + "page_signup.fxml",false);
        Navigation.addPage("main",BaseAddress + "page_main.fxml",false);
    }

    public void seed(){
        Restaurant r1 = new Restaurant("تک فود","+9812547852", Arrays.asList(
                new Food("غذای 1",9.99f,10),
                new Food("غذای 2",15.99f,10),
                new Food("غذای 3",5f,10),
                new Food("غذای 4",6.5f,10),
                new Food("غذای 5",52f,10)
        ));

        Restaurant r2 = new Restaurant("فودستان","+9812547852", Arrays.asList(
                new Food("غذای 6",7f,10),
                new Food("غذای 7",1f,10),
                new Food("غذای 8",21f,10)
        ));

        Storage.restaurants.add(r1);
        Storage.restaurants.add(r2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
