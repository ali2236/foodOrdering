package aligator.models;

import aligator.PersianCalendar;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class PersianDate implements Serializable {
    private long milies;

    public PersianDate(){
        PersianCalendar persianCalendar = new PersianCalendar();
        milies = persianCalendar.getTimeInMillis();
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
