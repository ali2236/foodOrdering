package aligator.lists.food;

import aligator.models.Cart;
import aligator.models.Food;
import aligator.navigation.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;

import java.io.IOException;

public class FoodCell extends ListCell<Food> {

    private Food item;

    @FXML
    public Text name;
    @FXML
    public Text price;
    @FXML
    public Text delivery_price;
    @FXML
    public Button more;
    @FXML
    public Button add_to_basket;

    public FoodCell(){
        loadFXML();
    }

    @FXML
    private void loadFXML(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../layouts/cell_food.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(Food item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
            this.item = null;
        } else {
            this.item = item;

            // set data
            name.setText(item.getName());
            price.setText("قیمت : " + item.getPrice());
            delivery_price.setText("هزینه پیک : " + item.getDeliveryPrice());
            more.setOnAction(this::onMoreClicked);
            add_to_basket.setOnAction(this::onAddToBasketClicked);

            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        }
    }

    private void onMoreClicked(ActionEvent event){
            Navigation.toDynamic("food",item);
    }

    private void onAddToBasketClicked(ActionEvent event){
        Cart c = Cart.getInstence();
        Integer last = c.getItem(item.getId());
        if (last < item.getStock()) {
            c.setItem(item, last + 1);
        }
    }

    @Override
    public void updateSelected(boolean selected) {
        //super.updateSelected(selected);
    }
}
