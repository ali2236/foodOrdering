package aligator.models;

import aligator.utils.PersianDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recite implements Serializable {
    public PersianDate date;
    public List<CartItem> products;
    public Double total;

    public Recite(PersianDate date,List<CartItem> products,Double total){
        this.date = date;
        this.products = products;
        this.total = total;
    }
}
