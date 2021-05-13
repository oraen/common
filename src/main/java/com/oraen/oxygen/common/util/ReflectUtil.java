package com.oraen.oxygen.common.util;


import com.oraen.oxygen.common.structure.map.FieldShelf;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectUtil {
    private static Map<Class<?>, FieldShelf> cache = new ConcurrentHashMap<>(16);

    /**
     *获取一个类的所有字段， 包括他所有父类
     */
    public static FieldShelf getAllFields(Class<?> clazz){
        if(cache.containsKey(clazz)){
            return cache.get(clazz);
        }
        FieldShelf re = new FieldShelf();

        Class<?> father = clazz.getSuperclass();
        if(father != Object.class){
            re.putAll(getAllFields(father));
        }

        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            re.put(field.getName(), field);
        }

        cache.put(clazz, re);
        return re;
    }

    public static FieldShelf getAllFields(Object object){
        /*防止静态委派导致的误判*/
        if(object instanceof Class){
            Class<?> clazz = (Class<?>) object;
            return getAllFields(clazz);
        }else{
            Class<?> clazz = object.getClass();
            return getAllFields(clazz);
        }
    }

    public static Field getField(Object o, String name){
        return getAllFields(o).get(name);
    }

    public static Object getFieldValue(Object o, String name){
        return getFieldValue(o, getField(o, name));
    }

    public static Object getFieldValue(Object o, Field field){
        try{
            return field.get(o);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void setField(Object o, String name, Object value) {
        Field f = getField(o, name);
        try{
            f.set(o, value);
        }catch (Exception e){
            setFieldAuto(o, f, value.toString());
        }
    }


    public static void setFieldAuto(Object o, Field f, String sValue) {
        try{
            Class<?> type = f.getType();
            Object value = CommonUtil.translate(sValue, type);
            f.set(o, value);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}

