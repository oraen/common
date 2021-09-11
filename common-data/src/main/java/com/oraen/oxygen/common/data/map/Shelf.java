package com.oraen.oxygen.common.data.map;

import sun.awt.image.ImageWatched;

import java.util.LinkedHashMap;
import java.util.Map;

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
        return v == null ? null : v.toString();
    }

//    public int getInt(String key){
//        Object v = get(key);
//        return v == null ? null : v.toString();
//    }
}
