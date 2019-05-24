package aligator.controllers;

import aligator.navigation.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import aligator.models.Food;
import aligator.storage.DataProvider;
import aligator.lists.food.FoodCellFactory;

public class MainController {

    @FXML
    public ListView<Food> listView;
    @FXML
    public Button cart;
    @FXML
    public Button profile;

    @FXML
    private void initialize() {
        listView.setCellFactory(new FoodCellFactory());
        listView.setItems(DataProvider.getFoods());
    }

    public void onCartButtonClicked(ActionEvent event){
        Navigation.toDialog("cart");
    }

    public void onProfileButtonClicked(ActionEvent event){
        Navigation.to("profile");
    }
}
