package com.oraen.oxygen.common.util;

import java.util.Collection;

public class StatisticsUtil {

    public static double max(double... values){
        if(values == null || values.length == 0){
            return Double.NaN;
        }else{
            int len = values.length;
            double max = values[0];
            for(int i=1; i<len; i++){
                if(values[i] > max){
                    max = values[i];
                }
            }
            return max;
        }
    }


    public static double min(double... values){
        if(values == null || values.length == 0){
            return Double.NaN;
        }else{
            int len = values.length;
            double min = values[0];
            for(int i=1; i<len; i++){
                if(values[i] < min){
                    min = values[i];
                }
            }
            return min;
        }
    }

    public static double sum(double... values){
        if(values == null || values.length == 0){
            return Double.NaN;
        }else{
            double sum = 0;
            for (double value : values) {
                sum += value;
            }
            return sum;
        }
    }

    public static double ave(double... values){
        return sum(values) / values.length;
    }
}
