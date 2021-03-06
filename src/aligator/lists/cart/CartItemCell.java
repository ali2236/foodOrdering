package aligator.lists.cart;

import aligator.models.Cart;
import aligator.models.CartItem;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;

public class CartItemCell extends ListCell<CartItem> {

    private CartItem item;

    @FXML
    public Text name;
    @FXML
    public Text price;
    @FXML
    public Button delete;

    public CartItemCell(){
        loadFXML();
    }

    @FXML
    private void loadFXML(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../layouts/cell_cart_item.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(CartItem item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item==null) {
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
            this.item = null;
        } else {
            this.item = item;

                // set data
                name.setText(item.item.getName());
                price.setText(item.amount + " x " + item.item.getPrice());
                delete.setOnAction(this::onDelete);

            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        }
    }


    private void onDelete(ActionEvent event){
        Cart.getInstence().removeItem(item.id);
    }

    @Override
    public void updateSelected(boolean selected) {
        //super.updateSelected(selected);
    }
}
