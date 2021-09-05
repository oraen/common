package com.oraen.oxygen.common.data.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Leach<E> {

    default<T extends E> void leach(Collection<T> col){
        List<T> list = new ArrayList<>(col);
        col.clear();
        for(T t : list){
            if(retain(t)){
                col.add(t);
            }
        }
    }

    boolean retain(E e);


}
