package aligator.models;

import java.util.List;

public abstract class Shop<T extends Product> {
    private String name;
    private List<T> products;
    private String phoneNumber;

    public Shop(String name, String phoneNumber,List<T> products){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<T> getProducts() {
        return products;
    }
}
