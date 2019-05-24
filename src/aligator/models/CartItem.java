package aligator.models;

public class CartItem {
    public Integer id;
    public Product item;
    public Integer amount;

    public CartItem(Product item, Integer amount) {
        this.id = item.getId();
        this.item = item;
        this.amount = amount;
    }
}
