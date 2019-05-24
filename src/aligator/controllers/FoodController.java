package aligator.controllers;

import aligator.models.Food;
import aligator.navigation.IDynamicPage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class FoodController implements IDynamicPage {

    // must be injected by the caller
    private Food food;

    @FXML
    public Text name;
    @FXML
    public Text price;
    @FXML
    public Text delivery_price;
    @FXML
    public Button add_to_basket;
    @FXML
    public Text description;

    public void start(){
        if (food != null) {
            name.setText(food.getName());
            price.setText("قیمت : " + food.getPrice());
            delivery_price.setText("هزینه پیک : " + food.getDeliveryPrice());
            description.setText(food.getDescription());
            //TODO: Add to basket button
        }
    }

    @Override
    public void setObject(Object object) {
        food = (Food) object;
        start();
    }
}
