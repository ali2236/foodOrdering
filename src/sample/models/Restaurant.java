package sample.models;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Restaurant extends Shop<Food> {


    public Restaurant(String name, String phoneNumber,List<Food> foods){
        super(name,phoneNumber,foods);
    }

    public List<Food> getFoodList(){
        return getProducts();
    }
}
