package com.oraen.oxygen.common.data.collection;

import com.oraen.oxygen.common.data.map.Shelf;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ListConverterUtil {
    //SK = STRING KEY
    public static<T> Map<String, Object> toSKMap(Collection<T> col){
        Shelf shelf = new Shelf();
        int index = 0;
        for(Object o : col){
            shelf.put(String.valueOf(index), o);
            index ++;
        }

        return shelf;
    }

    public static<T> Map<Integer, Object> toMap(Collection<T> col){
        Map<Integer, Object> map = new LinkedHashMap<>();
        int index = 0;
        for(Object o : col){
            map.put(index, o);
            index ++;
        }

        return map;
    }
}
