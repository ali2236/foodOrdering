package aligator.models;


import aligator.controllers.CartController;
import com.sun.javafx.collections.ObservableMapWrapper;
import javafx.collections.ObservableMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// singleton
public class Cart {
    private static Cart cart = new Cart();
    public static Cart getInstence(){return cart;}

    // id -> product,spinner
    private Map<Integer,CartItem> orders = new HashMap<>();
    private List<CartCallback> callbacks = new ArrayList<>();

    public void setItem(Product item,Integer amount){
        if (orders.containsKey(item.getId())){ // product already in cart
             orders.get(item.getId()).amount = amount;
        } else { // not yet in cart
            orders.put(item.getId(),new CartItem(item,amount));
        }
        invokeUpdate();
    }

    public void setItem(Product item){
        setItem(item,1);
    }

    public Integer getItem(Integer id){
        if (orders.containsKey(id)){
            return orders.get(id).amount;
        } else {
            return 0;
        }
    }

    public void removeItem(Integer id){
        orders.remove(id);
        invokeUpdate();
    }

    private void invokeUpdate(){
        for (CartCallback c : callbacks){
            if (c!=null){
                c.onCartUpdated();
            }
        }
    }

    public Double getTotal(){
        double total = 0.0;
        for (CartItem cartItem : orders.values()){
            if (cartItem != null){
                total += cartItem.item.getPrice() * cartItem.amount;
            }
        }
        return total;
    }

    public Recite generateRecite(){
        Recite recite = new Recite();
        recite.total = getTotal();
        recite.products.addAll(orders.values());
        return recite;
    }

    public Map<Integer,CartItem> getItems() {
        return orders;
    }

    public void addListener(CartCallback cartCallback) {
        callbacks.add(cartCallback);
    }
}
