package aligator.views;

import aligator.models.Order;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class OrderCellFactory implements Callback<ListView<Order>, ListCell<Order>> {
    @Override
    public ListCell<Order> call(ListView<Order> param) {
        return new OrderCell();
    }
}
