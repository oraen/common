package com.oraen.oxygen.common.data.display;

public class ObjectUtil {
    public static<T> T getIns(Class<T> clazz){
        try{
            return clazz.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
