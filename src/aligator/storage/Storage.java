package aligator.storage;

import aligator.models.Food;
import aligator.models.Order;
import aligator.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    public static List<Restaurant> restaurants = new ArrayList<>();

    public static List<Food> getFoods(){
        List<Food> foods = new ArrayList<>(10);
        for (Restaurant r : restaurants){
            foods.addAll(r.getFoodList());
        }
        return foods;
    }

    public static List<Order> getOrders() {
        return null;
    }
}
