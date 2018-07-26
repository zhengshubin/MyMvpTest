package com.gdqt.mymvptest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FormatUtils {
    public static String DateFormat(long time){
        SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd" +"\n"+"HH:mm:ss",Locale.CHINA);
       return format.format(time );

    }
}
