package aligator.controllers;

import aligator.lists.food.FoodCellFactory;
import aligator.models.Shop;
import aligator.navigation.IDynamicPage;
import aligator.navigation.Navigation;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class ShopController implements IDynamicPage {

    public ListView listView;
    public Button main;
    public Text name;
    public Text phone;
    public Text address;
    public Text hours;
    private Shop shop;

    public void goToMain(ActionEvent event){
        Navigation.to("main");
    }

    private void start(){
        listView.setCellFactory(new FoodCellFactory());
        listView.setItems(FXCollections.observableList(shop.getProducts()));

        name.setText(shop.getName());
        phone.setText("شماره تلفن : "+shop.getPhoneNumber());
        address.setText("آدرس : "+shop.getAddress());
        hours.setText("ساعت کاری : "+shop.getWorkingHours());
    }

    @Override
    public void setObject(Object object) {
        this.shop = (Shop) object;
        start();
    }
}
