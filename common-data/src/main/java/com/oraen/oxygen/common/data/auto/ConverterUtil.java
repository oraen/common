package com.oraen.oxygen.common.data.auto;

import com.oraen.oxygen.common.data.auto.StrInstar;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ConverterUtil {

    public static<T> T convertEntity(Object source, Class<T> clazz){
        if(clazz.isInstance(source)){
            return (T)source;
        }

        return new StrInstar(source).getEntity(clazz);
    }

    public static int covertInt(Object source){
        return new StrInstar(source).getInt();
    }

    public static double covertDouble(Object source){
        return new StrInstar(source).getNum();

    }

    public static boolean covertBoolean(Object source){
        return new StrInstar(source).getBoolean();
    }

    public static byte[] covertBytes(Object source){
        return new StrInstar(source).getBytes();
    }

    public static String covertString(Object source){
        return new StrInstar(source).getString();
    }

    public static Map<String, Object> covertMap(Object source){
        return new StrInstar(source).getMap();
    }

    public static<T> List<T> covertList(Object source, Class<T> clazz){
        return new StrInstar(source).getList(clazz);
    }
}
