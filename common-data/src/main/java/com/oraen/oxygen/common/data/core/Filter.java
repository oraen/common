package com.oraen.oxygen.common.data.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Filter<E> {

    default List<E> filter(Collection<? extends E> list){
        List<E> re = new ArrayList<>();
        for(E e : list){
            if(! isOut(e)){
                re.add(e);
            }
        }

        return re;
    }

    boolean isOut(E e);
}
