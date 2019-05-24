package aligator;

import aligator.file.FileServer;
import aligator.file.RegisterFile;
import aligator.models.Drink;
import aligator.models.Meal;
import javafx.application.Application;
import javafx.stage.Stage;
import aligator.models.Restaurant;
import aligator.navigation.RegisterNavigation;
import aligator.navigation.Navigation;
import aligator.storage.Storage;

import java.util.Arrays;

public class Main extends Application implements RegisterNavigation, RegisterFile {

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
        final String BaseAddress = "../layouts/";
        Navigation.addPage("login",BaseAddress + "page_login.fxml");
        Navigation.addPage("signup",BaseAddress + "page_signup.fxml");
        Navigation.addPage("main",BaseAddress + "page_main.fxml");
        Navigation.addPage("profile",BaseAddress + "page_profile.fxml");

        Navigation.addDynamicPage("food",BaseAddress + "page_food.fxml");
        Navigation.addDialogPage("cart",BaseAddress + "dialog_cart.fxml");
    }

    @Override
    public void addFiles() {
        final String BaseAddress = "/data/";
        FileServer.addAppFile("recites",BaseAddress + "recites.smg");
        FileServer.addAppFile("tracking",BaseAddress + "tracking.smg");
    }

    private void seed(){
        Restaurant r1 = new Restaurant("تک فود","+9812547852", Arrays.asList(
                new Drink("غذای 1",9.999,10,false,0.200),
                new Drink("غذای 2",15.999,10,true,1),
                new Meal("غذای 3",5.000,10,true,1),
                new Meal("غذای 4",6.500,10,true,1),
                new Meal("غذای 5",52.000,10,true,5)
        ));

        Restaurant r2 = new Restaurant("فودستان","+9812547852", Arrays.asList(
                new Drink("غذای 6",7.000,10,true,0.300),
                new Drink("غذای 7",1.000,10,true,0.100),
                new Meal("غذای 8",21.000,10,false,1)
        ));

        Storage.restaurants.add(r1);
        Storage.restaurants.add(r2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
