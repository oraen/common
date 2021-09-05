package com.oraen.oxygen.common.data.display;

import java.util.*;

public interface MapFilter<V> extends Judge<V>{

    default<K, VS extends V> Map<K, VS> filter(Map<K, VS> map){
        Map<K, VS> re = new HashMap<>();
        for(Map.Entry<K, VS> entry : map.entrySet()){
            if(isLegal(entry.getValue())){
                re.put(entry.getKey(), entry.getValue());
            }
        }

        return re;
    }
}
