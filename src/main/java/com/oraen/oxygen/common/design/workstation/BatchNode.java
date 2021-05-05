package com.oraen.oxygen.common.design.workstation;

import java.util.Collection;
import java.util.List;

public interface BatchNode<E> extends WorkNode<Collection<E>>{

    @Override
    default void execute(Collection<E> target) {
        for(E e : target){
            repeat(e);
        }
    }


    void repeat(E e);

}
