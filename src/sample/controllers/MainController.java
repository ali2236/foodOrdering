package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import sample.models.Food;
import sample.views.DataProvider;
import sample.views.FoodCell;
import sample.views.FoodCellFactory;

public class MainController {

    @FXML
    public ListView<Food> listView;

    @FXML
    private void initialize() {
        listView.setCellFactory(new FoodCellFactory());
        listView.setItems(DataProvider.getFoods());
    }
}
