package com.oraen.oxygen.common.data.display;

import java.util.HashMap;
import java.util.Map;

public interface MapLeach <V> extends Judge<V>{

    default void filter(Map<?, ? extends V> map){
        for(Object key : map.keySet()){
            if(! isLegal(map.get(key))){
                map.remove(key);
            }
        }

    }
}
