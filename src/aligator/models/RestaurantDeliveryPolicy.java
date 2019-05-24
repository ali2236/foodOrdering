package aligator.models;

public interface RestaurantDeliveryPolicy {
    String getDeliveryPriceBasedOnProduct(Food food);
}
