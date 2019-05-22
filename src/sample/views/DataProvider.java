package sample.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.models.Food;
import sample.storage.Storage;

import java.util.Observable;

public class DataProvider {

    public static ObservableList<Food> getFoods(){
        return FXCollections.observableList(Storage.getFoods());
    }
}
