package aligator.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Order<T extends Product> {
    private PersianDate date;
    private List<T> products;
    private float total = 0f;

    private Order(){}

    public Order(List<T> products){
        this.products = products;
        for (T product : products){
            if (product != null){
                total += product.getPrice();
            }
        }
        date = new PersianDate();
    }

    public float getTotal() {
        return total;
    }

    public List<T> getProducts() {
        return products;
    }

    public Recite generateRecite(){
        Recite r = new Recite();
        r.date = date;
        r.products = products;
        r.total = total;
        return r;
    }

    public static Order createFromRecite(Recite recite){
        Order o = new Order();
        o.date = recite.date;
        o.total= recite.total;
        o.products = recite.products;
        return o;
    }

    public String getDate() {
        return date.toString();
    }
}
