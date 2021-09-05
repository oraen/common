package com.oraen.oxygen.common.data.display;

public class ValueUtil {

    @SafeVarargs
    public static<T> T frontNotNull(T...  ts){
        for(T t : ts){
            if(t != null){
                return t;
            }
        }

        return null;
    }
}
