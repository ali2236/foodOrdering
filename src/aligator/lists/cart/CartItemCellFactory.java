package aligator.lists.cart;

import aligator.models.CartItem;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CartItemCellFactory implements Callback<ListView<CartItem>, ListCell<CartItem>> {
    @Override
    public ListCell<CartItem> call(ListView<CartItem> param) {
        return new CartItemCell();
    }
}
