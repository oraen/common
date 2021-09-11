package com.oraen.oxygen.common.data.string;

public class StringUtil {
    public static boolean isBlank(String str){
        return (str == null) || (str.trim().length() == 0);
    }

    public static String compress(String str){
        return str == null ? null : str.replaceAll("[ \r\n]", "");
    }
}
