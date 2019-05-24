package aligator.utils;

import aligator.utils.PersianCalendar;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersianDate implements Serializable {
    private long milies;

    public PersianDate(){
        milies = new Date().getTime();
    }

    @Override
    public String toString() {
        Date d = new Date(milies);
        String time = new SimpleDateFormat("HH:mm:ss").format(d);

        PersianCalendar persianCalendar = new PersianCalendar(milies);
        int year = persianCalendar.getPersianYear();
        int month = persianCalendar.getPersianMonth();
        int day = persianCalendar.getPersianDay();

        return String.format("%d/%d/%d - %s",year,month,day,time);
    }
}
