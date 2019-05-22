package sample.views;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sample.models.Food;

public class FoodCellFactory implements Callback<ListView<Food>, ListCell<Food>> {
    @Override
    public ListCell<Food> call(ListView<Food> param) {
        return new FoodCell();
    }
}
