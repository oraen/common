package com.oraen.oxygen.common.math.statistics;


import com.oraen.oxygen.common.model.enumeration.math.Order;

public class CheckUtil {
    public static boolean checkOrder(Order order, double... doubles){
        return StatisticsUtil.order(doubles) == order;
    }

    public static void checkOrder(Order order, RuntimeException runtimeException, double... doubles) {
        if(! checkOrder(order, doubles)){
            throw runtimeException;
        }
    }
}
