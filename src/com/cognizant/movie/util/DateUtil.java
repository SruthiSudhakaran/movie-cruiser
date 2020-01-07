package com.cognizant.movie.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date convertToDate(String userDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);
            return format.parse(userDate); // string to date conversion

        } catch (ParseException e) {
            System.out.println("Date/Format went wrong");
        }
        return null;
    }
}
