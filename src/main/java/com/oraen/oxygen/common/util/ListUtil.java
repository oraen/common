package com.oraen.oxygen.common.util;

import java.util.*;

public class ListUtil {
    public static boolean isEmpty(Collection<?> col){
        return col == null || col.size() == 0;
    }

    public static<T> List<T> joint(Collection<? extends T>... lists){
        List<T> re = new ArrayList<>(20);
        for(Collection<? extends T> c : lists){
            re.addAll(c);
        }
        return re;
    }

    public static<T> List<T> pushArray(List<T> list, T[] array){
        int length = array.length;
        return pushArray(list, array, 0, length);
    }

    public static<T> List<T> pushArray(List<T> list, T[] array, int start, int length){
        if(isEmpty(list) || start < 0 || start > array.length || length > array.length){
            throw new IllegalArgumentException();
        }

        int end = start + length;
        list.addAll(Arrays.asList(array).subList(start, end));

        return list;
    }





}
