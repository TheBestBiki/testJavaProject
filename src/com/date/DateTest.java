package com.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/5/22
 */
public class DateTest {


    public static void main(String[] args)  {
        //getSpecifiedTime();
        //System.out.println(getTodayDateJson());
        int a = 200;

    }



    /**
     * 获取指定时间
     */
    private static void getSpecifiedTime() throws ParseException {
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate1 = dateFormat1.parse("2009-06-01");
        Date myDate2 = new Date();
        System.out.println(myDate1.after(new Date()));
    }

    /**
     * 获取昨天此时的日期Date, 不包括时间. 如yyyy-MM-dd 00:00:00
     *
     * @return yyyy-MM-dd 00:00:00
     */
    public static String getTodayDateJson() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "{\"updateTime\":\""+formatter.format(date)+"\"}";
        //return "{\"updateTime\":\"2021-12-27 18:27:04\"}";
    }

}
