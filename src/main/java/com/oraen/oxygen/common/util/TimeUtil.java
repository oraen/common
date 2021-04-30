package com.oraen.oxygen.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    //获取 yyyy-mm-dd hh:mm:ss 的格式的当前时间
    public static String getNow(){
        Date date=new Date();
        DateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;//可以精确到时分秒毫秒
        return df.format(date);
    }
}
