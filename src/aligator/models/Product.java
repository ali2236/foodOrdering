package aligator.models;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private static Integer ID = 0;
    private Integer id;
    private String name;
    private Long price;
    private String description;
    private Integer stock;
    protected Shop shop;

    protected Product(String name, Long price, String description, Integer stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;

        id = ID;
        ID++;
    }

    public synchronized void modifyStock(Integer amount){
        this.stock += amount;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStock() {
        return stock;
    }

    @Override
    public int hashCode() {
        return 31 * id + name.hashCode() + price.hashCode() + description.hashCode() + shop.hashCode();
    }
}
