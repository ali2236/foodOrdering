package aligator.models;

import aligator.utils.PersianDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recite implements Serializable {
    public PersianDate date;
    public List<CartItem> products;
    public Double total;
    private String trackingCode;

    public Recite(PersianDate date,List<CartItem> products,Double total){
        this.date = date;
        this.products = products;
        this.total = total;
        this.trackingCode = generateTrackingCode();
    }

    public String getTrackingCode(){
        return trackingCode;
    }

    private String generateTrackingCode(){
        int numberBase10 = Math.abs(hashCode());
        String numberBase32 = Integer.toString(numberBase10,32);
        return numberBase32;
    }

    @Override
    public int hashCode() {
        return 3 * date.hashCode() + products.hashCode() + Double.hashCode(total);

    }
}
