package aligator.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import aligator.models.Food;
import aligator.views.food.DataProvider;
import aligator.views.food.FoodCellFactory;

public class MainController {

    @FXML
    public ListView<Food> listView;

    @FXML
    private void initialize() {
        listView.setCellFactory(new FoodCellFactory());
        listView.setItems(DataProvider.getFoods());
    }
}
