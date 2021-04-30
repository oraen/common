package com.oraen.oxygen.common.structure.DuplexMap;

import java.util.List;
import java.util.Set;

public interface DuplexMap<T1, T2> {
    int size();

    boolean isEmpty();

    boolean containsKey1(T1 key);

    boolean containsKey2(T2 key);

    boolean containsValue1(T2 value);

    boolean containsValue2(T1 value);

    T2 get1(T1 key);

    T1 get2(T2 key);

    void put(T1 kv1, T2 kv2);

    void remove1(T1 k1);

    void remove2(T2 k2);

    public void clear();

    Set<T1> getKey1s();

    Set<T2> getKey2s();



}
