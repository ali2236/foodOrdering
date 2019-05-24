package aligator.models;


import com.sun.javafx.collections.ObservableMapWrapper;
import javafx.collections.ObservableMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// singleton
public class Cart {
    private static Cart cart = new Cart();
    public static Cart getInstence(){return cart;}

    // id -> product,spinner
    private ObservableMap<Integer,CartItem> orders = new ObservableMapWrapper<>(new HashMap<>());
    private List<CartCallback> callbacks = new ArrayList<>();

    public void setItem(Product item,Integer amount){
        if (orders.containsKey(item.getId())){ // product already in cart
             orders.get(item.getId()).amount = amount;
             invokeUpdate();
        } else { // not yet in cart
            orders.put(item.getId(),new CartItem(item,amount));
        }
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
    }

    private void invokeUpdate(){
        orders.put(Integer.MAX_VALUE,null);
        orders.remove(Integer.MAX_VALUE);
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

    public ObservableMap<Integer,CartItem> getItems() {
        return orders;
    }
}
