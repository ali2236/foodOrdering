package sample.storage;

import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.models.Food;
import sample.models.Restaurant;
import sample.storage.Users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Storage {

    public static List<Restaurant> restaurants = new ArrayList<>();

    public static List<Food> getFoods(){
        List<Food> foods = new ArrayList<>(10);
        for (Restaurant r : restaurants){
            foods.addAll(r.getFoodList());
        }
        return foods;
    }
}
