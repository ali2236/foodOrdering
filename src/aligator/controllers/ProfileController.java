package aligator.controllers;

import aligator.file.FileServer;
import aligator.lists.recite.ReciteCellFactory;
import aligator.models.Recite;
import aligator.navigation.Navigation;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class ProfileController {

    public ListView listView;

    @FXML
    public void initialize(){
        ArrayList<Recite> recites = FileServer.getList("recites");
        listView.setCellFactory(new ReciteCellFactory());
        listView.setItems(FXCollections.observableList(recites));
    }

    public void goToMain(ActionEvent event){
        Navigation.to("main");
    }
}
