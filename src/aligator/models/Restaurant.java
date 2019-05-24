package aligator.models;

import java.util.List;

public class Restaurant extends Shop<Food> implements RestaurantDeliveryPolicy{

    RestaurantDeliveryPolicy deliveryPolicy = this;

    public Restaurant(String name, String phoneNumber,List<Food> foods){
        super(name,phoneNumber,foods);
    }

    public List<Food> getFoodList(){
        return getProducts();
    }

    String getDeliveryPolicy(Food food){
        return deliveryPolicy.getDeliveryPriceBasedOnProduct(food);
    }

    public void setDeliveryPolicy(RestaurantDeliveryPolicy deliveryPolicy){
        this.deliveryPolicy = deliveryPolicy;
    }

    @Override
    public String getDeliveryPriceBasedOnProduct(Food food) {
        return "رایگان";
    }
}
