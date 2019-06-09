package aligator.models;

import aligator.storage.Users.UserManager;
import aligator.utils.PersianDate;

import java.io.Serializable;
import java.util.List;

public class Receipt implements Serializable {
    public PersianDate date;
    public List<CartItem> products;
    public Long total;
    private String trackingCode;

    public Receipt(PersianDate date, List<CartItem> products, Long total){
        this.date = date;
        this.products = products;
        this.total = total;
        this.trackingCode = generateTrackingCode();
    }

    public String getTrackingCode(){
        return trackingCode;
    }

    private String generateTrackingCode(){
        int numberBase10 = Math.abs(hashCode() + UserManager.getCurrentUsername().hashCode());
        String numberBase32 = Integer.toString(numberBase10,32);
        return numberBase32;
    }

    @Override
    public int hashCode() {
        return 3 * date.hashCode() + products.hashCode() + Long.hashCode(total);

    }
}
