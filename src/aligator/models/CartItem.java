package aligator.models;

import java.io.Serializable;

public class CartItem implements Serializable {
    public Integer id;
    public Product item;
    public Integer amount;

    public CartItem(Product item, Integer amount) {
        this.id = item.getId();
        this.item = item;
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return 15 * id + item.hashCode() + amount;
    }
}
