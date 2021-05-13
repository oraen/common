package com.oraen.oxygen.common.util;

import java.lang.reflect.Field;
import java.util.*;


@SuppressWarnings("unchecked")
public class MapUtil {

    public static boolean isEmpty(Map<?,?> map){
        return map == null || map.size() == 0;
    }

    public static Map<String, Object> createMap(Object entity) {
        try{
            Map<String, Object> map = new HashMap<>();
            Field[] fields = entity.getClass().getDeclaredFields();
            for(Field f : fields){
                f.setAccessible(true);
                map.put(f.getName(), f.get(entity));
            }
            return map;
        }catch (IllegalAccessException e){
            e.printStackTrace();
            return null;
        }

    }

    public static<T> T createEntity(Map<String, ?> map, Class<T> clazz) {
        try{
            T t = CommonUtil.create(clazz);
            for(Map.Entry<String, ?> entry : map.entrySet()){
                try{
                    Field f = clazz.getDeclaredField(entry.getKey());
                    f.setAccessible(true);
                    Class<?> type = f.getType();
                    f.set(t, CommonUtil.translate(entry.getValue(), type));

                }catch (NoSuchFieldException ignored){
                }
            }
            return t;

        }catch (IllegalAccessException e){
            e.printStackTrace();
            return null;
        }

    }

    @SafeVarargs
    public static Map<String, Object> joint(Map<String, ?>... lists){
        Map<String, Object> re = new HashMap<>();
        for(Map<String, ?> map : lists){
            re.putAll(map);
        }
        return re;
    }


    public static<K, V> Map<K, V> changeType(Map<?, ?> source){
        Map<K, V> re = new HashMap<>(source.size() * 2); //防止0.75扩容影响效率
        for(Map.Entry<?, ?> entry : source.entrySet()){
            re.put((K)entry.getKey(), (V)entry.getValue());
        }
        return re;
    }

}
