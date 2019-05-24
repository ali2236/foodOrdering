package aligator.models;

import aligator.utils.PersianDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recite implements Serializable {
    public PersianDate date = new PersianDate();
    public List<CartItem> products = new ArrayList<CartItem>();
    public Double total = 0.0;
}
