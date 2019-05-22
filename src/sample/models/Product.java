package sample.models;

public abstract class Product {
    private String name;
    private Float price;
    private String description;
    private Integer amount;
    private Shop shop;

    protected Product(String name, Float price, String description, Integer amount) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = amount;
    }

    public synchronized void modifyStock(Integer amount){
        this.amount += amount;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }
}
