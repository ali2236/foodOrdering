package aligator.lists.food;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import aligator.models.Food;

public class FoodCellFactory implements Callback<ListView<Food>, ListCell<Food>> {
    @Override
    public ListCell<Food> call(ListView<Food> param) {
        return new FoodCell();
    }
}
