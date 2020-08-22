package com.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/5/22
 */
public class DateTest {


    public static void main(String[] args)  {
        //getSpecifiedTime();
        Integer aa=111111110;
        Integer bb=111111110;
        System.out.println(aa.equals(bb));
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

}
