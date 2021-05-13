package com.oraen.oxygen.common.util;

import com.oraen.oxygen.common.exception.StringAnalysisException;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Map;

public class StringUtil {

    public static char getAt(@NotNull String str, int index){
        int length = str.length();
        if(length == 0){
            throw new StringAnalysisException("传入非法的空字符");
        }

        while(index < 0){
            index += length;
        }

        while(index >= length){
            index -= length;
        }
        return str.charAt(index);
    }

    public static boolean isBlank(String str){
        return (str == null || str.trim().isEmpty());
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

    public static void main(String[] args) {
        System.out.println(getAt("阿额松大", -2));
    }


}
