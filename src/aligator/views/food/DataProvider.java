package aligator.views.food;

import aligator.models.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aligator.models.Food;
import aligator.storage.Storage;

public class DataProvider {

    public static ObservableList<Food> getFoods(){
        return FXCollections.observableList(Storage.getFoods());
    }

    public static ObservableList<Order> getOrders(){
        return FXCollections.observableList(Storage.getOrders());
    }
}
