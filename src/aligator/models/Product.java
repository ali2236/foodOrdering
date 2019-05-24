package aligator.models;

public abstract class Product {
    private static Integer ID = 0;
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Integer stock;
    protected Shop shop;

    protected Product(String name, Double price, String description, Integer stock) {
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

    public Double getPrice() {
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
}
