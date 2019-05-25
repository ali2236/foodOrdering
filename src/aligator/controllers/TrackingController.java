package aligator.controllers;

import aligator.navigation.Navigation;
import javafx.event.ActionEvent;

public class TrackingController {
    public void goToMain(ActionEvent event) {
        Navigation.to("main");
    }
}
