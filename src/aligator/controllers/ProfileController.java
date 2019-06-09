package aligator.controllers;

import aligator.file.FileServer;
import aligator.lists.receipt.ReceiptCellFactory;
import aligator.models.Receipt;
import aligator.navigation.Navigation;
import aligator.storage.Users.UserManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ProfileController {

    public ListView listView;
    public Text username_text;

    @FXML
    public void initialize(){
        username_text.setText(UserManager.getCurrentUsername());

        ArrayList<Receipt> recipes = FileServer.getList(UserManager.getSafeUsername()+"-recipes");
        listView.setCellFactory(new ReceiptCellFactory());
        listView.setItems(FXCollections.observableList(recipes));
    }

    public void goToMain(ActionEvent event){
        Navigation.to("main");
    }
}
