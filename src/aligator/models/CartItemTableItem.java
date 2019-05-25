package aligator.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartItemTableItem {

    private SimpleIntegerProperty index;
    private SimpleStringProperty name;
    private SimpleIntegerProperty count;
    private SimpleDoubleProperty price;
    private SimpleDoubleProperty total;

    public CartItemTableItem(int index,CartItem cartItem){
        this.index = new SimpleIntegerProperty(index);
        name = new SimpleStringProperty(cartItem.item.getName());
        count = new SimpleIntegerProperty(cartItem.amount);
        price = new SimpleDoubleProperty(cartItem.item.getPrice());
        total = new SimpleDoubleProperty(cartItem.item.getPrice() * cartItem.amount);
    }

    // Auto generated getters and setters

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getCount() {
        return count.get();
    }

    public SimpleIntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getIndex() {
        return index.get();
    }

    public SimpleIntegerProperty indexProperty() {
        return index;
    }

    public void setIndex(int index) {
        this.index.set(index);
    }
}
