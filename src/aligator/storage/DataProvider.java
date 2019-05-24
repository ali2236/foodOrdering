package aligator.storage;

import aligator.models.Cart;
import aligator.models.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aligator.models.Food;
import javafx.collections.ObservableMap;

public class DataProvider {

    public static ObservableList<Food> getFoods(){
        return FXCollections.observableList(Storage.getFoods());
    }

    public static ObservableList<Order> getOrders(){
        return FXCollections.observableList(Storage.getOrders());
    }

    public static ObservableMap getCartItems() {
        return Cart.getInstence().getItems();
    }
}
