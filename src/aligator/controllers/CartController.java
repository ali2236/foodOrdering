package aligator.controllers;

import aligator.lists.cart.CartItemCellFactory;
import aligator.models.Cart;
import aligator.models.CartItem;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class CartController implements MapChangeListener<Integer, CartItem> {
    @FXML
    public ListView<CartItem> listView;
    @FXML
    public Button pay;
    @FXML
    public Text total;

    ObservableMap<Integer, CartItem> cartItems = Cart.getInstence().getItems();

    @FXML
    private void initialize() {
        listView.setCellFactory(new CartItemCellFactory());
        cartItems.addListener(this);
        setItems();
    }

    private void setItems(){
        ObservableList<CartItem> list = FXCollections.observableArrayList(cartItems.values());
        listView.setItems(list);
        setTotal();
    }

    private void setTotal(){
        total.setText(Cart.getInstence().getTotal().toString());
    }

    @Override
    public void onChanged(Change<? extends Integer, ? extends CartItem> change) {
        setItems();
    }

    @Override
    protected void finalize() throws Throwable {
        cartItems.removeListener(this);
        super.finalize();
    }
}
