package com.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/2/13
 */
public class DateCover {

    public static void main(String[] args) {
        //System.out.println(getGMT(new Date()));
        System.out.println(getGMT(getGMT("2020-03-02T22:59:24.147")));
    }

    public static String getGMT(Date dateCST) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("GMT")); // modify Time Zone.
        return(df.format(dateCST));
    }

    public static Date getGMT(String dateCST) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        Date date=null;
        try {
            date = sdf.parse(dateCST);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }



}
