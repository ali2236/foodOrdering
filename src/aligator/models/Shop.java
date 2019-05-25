package aligator.models;

import java.io.Serializable;
import java.util.List;

public abstract class Shop<T extends Product> implements Serializable {
    private String name;
    private String address;
    private String workingHours;
    private List<T> products;
    private String phoneNumber;

    public Shop(String name, String phoneNumber,List<T> products){
        this.name = name;
        this.address = "-";
        this.workingHours = "-";
        this.phoneNumber = phoneNumber;
        this.products = products;
        for (T product : products){
            if (product!= null){
                product.shop = this;
            }
        }
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

    public String getAddress(){
        return address;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode();
    }
}
