package aligator.models;

import java.util.List;

public class Restaurant extends Shop<Food> {


    public Restaurant(String name, String phoneNumber,List<Food> foods){
        super(name,phoneNumber,foods);
    }

    public List<Food> getFoodList(){
        return getProducts();
    }
}
