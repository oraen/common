package com.oraen.oxygen.common.data.core.node;

import com.oraen.oxygen.common.data.core.WorkNode;

import java.util.Collection;

public interface BatchNode<T> extends WorkNode<Collection<? extends T>> {
    @Override
    default void work(Collection<? extends T> ts) {
        for(T t : ts){
            doOne(t);
        }
    }

    void doOne(T t);
}
