package com.jason.jason_ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

     //日期转成字符串
    public static String  date2String(Date date, String fmt){
        SimpleDateFormat sdf=new SimpleDateFormat(fmt);
        String dateStr=sdf.format(date);
        return dateStr;

    }

    //字符串转成日期
    public static Date  String2date( String dateStr,String  fmt) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(fmt);
        Date date=sdf.parse(dateStr);
        return date;
    }
}
