package com.oraen.oxygen.common.data.map;

import com.oraen.oxygen.common.data.auto.StrInstar;
import com.oraen.oxygen.common.data.display.ConverterUtil;
import com.oraen.oxygen.common.data.display.ObjectUtil;
import com.oraen.oxygen.common.model.exception.TypeTransitionException;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Shelf extends LinkedHashMap<String, Object> {

    public Shelf(){}

    public Shelf(Object... kvs){
        int end = kvs.length - 1;
        for(int i = 0; i < end; i += 2){
            put(kvs[i].toString(), kvs[i + 1]);
        }
    }

    static Shelf from(Map<?, ?> map){
        Shelf shelf = new Shelf();
        for(Map.Entry<?, ?> entry : map.entrySet()){
            shelf.put(entry.getKey().toString(), entry.getValue());
        }

        return shelf;
    }

    public String getString(String key){
        Object v = get(key);
        if(v == null){
            return null;
        }else if(v instanceof String){
            return (String)v;
        }
        return ConverterUtil.covertString(v);
    }

    public int getInt(String key){
        Object v = get(key);
        if(v == null){
            throw new TypeTransitionException(null, int.class);
        }else if(v instanceof Integer){
            return (Integer) v;
        }
        return ConverterUtil.covertInt(v);
    }

    public double getDouble(String key){
        Object v = get(key);
        if(v == null){
            throw new TypeTransitionException(null, double.class);
        }else if(v instanceof Double){
            return (Double) v;
        }
        return ConverterUtil.covertDouble(v);
    }

    public Map<String, Object> getMap(String key){
        Object v = get(key);
        if(v == null){
            return new Shelf();
        }else if(v instanceof Map){
            return Shelf.from((Map<?, ?>)v);
        }
        return ConverterUtil.covertMap(v);
    }

    public<T> List<T> getList(String key, Class<T> clazz){
        Object v = get(key);
        if(v == null) {
            return new ArrayList<>();
        }
        return ConverterUtil.covertList(v, clazz);
    }

    public<T> T getEntity(String key, Class<T> clazz){
        Object v = get(key);
        if(v == null){
            return ObjectUtil.getIns(clazz);
        }else if(clazz.isInstance(v)){
            return (T)v;
        }
        return ConverterUtil.convertEntity(v, clazz);
    }
}
