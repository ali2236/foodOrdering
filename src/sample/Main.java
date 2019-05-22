package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.navigation.INavigation;
import sample.navigation.Navigation;

public class Main extends Application implements INavigation {

    @Override
    public void start(Stage primaryStage){

        addPrimaryStage(primaryStage);
        addPages();
        Navigation.to("signup");
    }

    @Override
    public void addPrimaryStage(Stage primaryStage) {
        Navigation.setPrimaryStage(primaryStage);
    }

    @Override
    public void addPages() {
        final String BaseAddress = "../Layouts/";
        Navigation.addPage("login",BaseAddress + "LoginPage.fxml",false);
        Navigation.addPage("signup",BaseAddress + "SignupPage.fxml",false);
        Navigation.addPage("main",BaseAddress + "MainPage.fxml",false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
