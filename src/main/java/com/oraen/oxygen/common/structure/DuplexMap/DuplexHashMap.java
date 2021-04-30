package com.oraen.oxygen.common.structure.DuplexMap;

import java.util.*;

public class DuplexHashMap<T1, T2> implements DuplexMap<T1, T2>{
    private Map<T1, T2> map1 = new HashMap<>();
    private Map<T2, T1> map2 = new HashMap<>();

    @Override
    public int size() {
        return map1.size();
    }

    @Override
    public boolean isEmpty() {
        return map1.isEmpty();
    }

    @Override
    public boolean containsKey1(T1 key) {
        return map1.containsKey(key);
    }

    @Override
    public boolean containsKey2(T2 key) {
        return map2.containsKey(key);
    }

    @Override
    public boolean containsValue1(T2 value) {
        return containsKey2(value);
    }

    @Override
    public boolean containsValue2(T1 value) {
        return containsKey1(value);
    }

    @Override
    public T2 get1(T1 key) {
        return map1.get(key);
    }

    @Override
    public T1 get2(T2 key) {
        return map2.get(key);
    }

    @Override
    public void put(T1 kv1, T2 kv2) {
        T2 old2 = map1.get(kv1);
        T1 old1 = map2.get(kv2);
        map1.remove(old1);
        map2.remove(old2);
        map1.put(kv1, kv2);
        map2.put(kv2, kv1);
    }

    @Override
    public void remove1(T1 k1) {
        T2 k2 = get1(k1);
        if(k2 != null){
            map1.remove(k1);
            map2.remove(k2);
        }

    }

    @Override
    public void remove2(T2 k2) {
        T1 k1 = get2(k2);
        if(k1 != null){
            map1.remove(k1);
            map2.remove(k2);
        }

    }

    @Override
    public void clear() {
        map1.clear();
        map2.clear();
    }

    @Override
    public Set<T1> getKey1s() {
        Set<T1> re = new HashSet<>(map1.keySet());
        return re;

    }

    @Override
    public Set<T2> getKey2s() {
        Set<T2> re = new HashSet<>(map2.keySet());
        return re;
    }

}
