package aligator.controllers;

import aligator.file.FileServer;
import aligator.lists.cart.CartItemCellFactory;
import aligator.models.Cart;
import aligator.models.CartCallback;
import aligator.models.CartItem;
import aligator.models.Receipt;
import aligator.navigation.Navigation;
import aligator.storage.users.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class CartController implements CartCallback {
    @FXML
    public ListView<CartItem> listView;
    @FXML
    public Button pay;
    @FXML
    public Text total;

    @FXML
    private void initialize() {
        listView.setCellFactory(new CartItemCellFactory());
        Cart.getInstence().addListener(this);
        setItems();
    }

    private void setItems(){
        listView.setItems(null);
        ObservableList<CartItem> list = FXCollections.observableArrayList(Cart.getInstence().getItems().values());
        listView.setItems(list);
        setTotal();
    }

    @FXML
    public void onPay(ActionEvent event){
        Receipt receipt = Cart.getInstence().generatereceipt();
        Navigation.toDynamicDialog("receipt",receipt);
        FileServer.appendItem(UserManager.getSafeUsername()+"-recipes",receipt);
        Cart.getInstence().clear();
    }

    private void setTotal(){
        total.setText(Cart.getInstence().getTotal().toString());
    }


    @Override
    public void onCartUpdated() {
        setItems();
    }
}
