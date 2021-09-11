package com.oraen.oxygen.common.data.collection;

import com.oraen.oxygen.common.data.display.Judge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Filter<E> extends Judge<E> {

    default List<E> filter(Collection<? extends E> list){
        List<E> re = new ArrayList<>();
        for(E e : list){
            if(isLegal(e)){
                re.add(e);
            }
        }

        return re;
    }

}
