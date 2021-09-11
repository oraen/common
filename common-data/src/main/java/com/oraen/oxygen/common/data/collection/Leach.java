package com.oraen.oxygen.common.data.collection;

import com.oraen.oxygen.common.data.display.Judge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Leach<E> extends Judge<E> {

    default<ES extends E> void leach(Collection<ES> col){
        List<ES> list = new ArrayList<>(col);
        col.clear();
        for(ES t : list){
            if(isLegal(t)){
                col.add(t);
            }
        }
    }



}
