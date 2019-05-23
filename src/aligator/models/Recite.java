package aligator.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Recite<T extends Product> implements Serializable {
    public PersianDate date;
    public List<T> products;
    public float total;
}
