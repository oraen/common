package com.oraen.oxygen.common.math.statistics;

import java.util.*;

@SuppressWarnings("unchecked")
public class StatisticsTable<T> {
    private final Map<T, Integer> table;

    public StatisticsTable(){
        this(new HashMap<>());
    }

    public StatisticsTable(Map<T, Integer> table){
        this.table = table;
    }

    public int get(T t){
        table.putIfAbsent(t, 0);
        return table.get(t);
    }

    public void set(T t, int num){
        table.put(t, num);
    }

    public void add(T t, int num){
        set(t, get(t) + num);
    }

    public void multiply(T t, int num){
        set(t, get(t) * num);
    }

    public void divide(T t, int num){
        set(t, get(t) / num);
    }

    public void addOne(T t){
        add(t, 1);
    }

    public void subtractOne(T t){
        add(t, -1);
    }

    public void clear(){
        table.clear();
    }

    public List<T> max(){
        int max = Integer.MIN_VALUE;
        for(T t : table.keySet()){
            int value = get(t);
            if(value > max){
                max = value;
            }
        }

        return getAll(max);
    }

    public List<T> min(){
        int min = Integer.MAX_VALUE;
        for(T t : table.keySet()){
            int value = get(t);
            if(value < min){
                min = value;
            }
        }

        return getAll(min);
    }

    public T getOne(int num){
        for(T t : table.keySet()){
            if(get(t) == num){
                return t;
            }
        }

        return null;
    }

    public List<T> getAll(int num){
        List<T> re = new ArrayList<>();
        for(T t : table.keySet()){
            if(get(t) == num){
                re.add(t);
            }
        }

        return re;
    }

    public List<T> getAll(){
        return new ArrayList<>(table.keySet());
    }

    public Map<T, Integer> saveAsMap(){
        Map<T, Integer> re = new HashMap<>();
        for(Map.Entry<T, Integer> entry : table.entrySet()){
            re.put(entry.getKey(), entry.getValue());
        }

        return re;
    }

    @SafeVarargs
    public static<T> StatisticsTable<T> createFrom(T... ts){
        StatisticsTable<T> re = new StatisticsTable<T>();
        for(T t : ts){
            re.addOne(t);
        }

        return re;
    }

    public static<T> StatisticsTable<T> createFrom(Collection<T> ts){
        return createFrom((T[])ts.toArray());
    }

    public static<T> StatisticsTable<T> createFrom(Map<T, Integer> map){
        return new StatisticsTable<>(map);

    }


}
