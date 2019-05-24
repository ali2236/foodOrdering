package aligator.controllers;

import aligator.models.Cart;
import aligator.models.Food;
import aligator.navigation.IDynamicPage;
import aligator.navigation.Navigation;
import com.sun.xml.internal.bind.v2.TODO;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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
    @FXML
    public Spinner<Integer> spinner;

    public void start(){
        if (food != null) {
            name.setText(food.getName());
            price.setText("قیمت : " + food.getPrice());
            delivery_price.setText("هزینه پیک : " + food.getDeliveryPrice());
            description.setText(food.getDescription());
            configureSpinner();
        }
    }

    private void configureSpinner(){
        int initialValue = Cart.getInstence().getItem(food.getId());
        SpinnerValueFactory.IntegerSpinnerValueFactory factory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,food.getStock(),initialValue);
        spinner.setValueFactory(factory);
    }

    public void addToCart(ActionEvent event){
        Cart.getInstence().setItem(food, spinner.getValue());
    }

    public void goToMain(ActionEvent event){
        Navigation.to("main");
    }

    public void openCart(ActionEvent event){
        Navigation.toDialog("cart");
    }

    public void goToShop(ActionEvent event){
        Navigation.toDynamic("shop",food.getRestaurant());
    }

    @Override
    public void setObject(Object object) {
        food = (Food) object;
        start();
    }
}
