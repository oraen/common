package com.oraen.oxygen.common.math.statistics;

import com.oraen.oxygen.common.model.enumeration.math.Order;

import java.util.List;

public class StatisticsUtil {

    //获取顺序
    public static Order order(double... doubles){
        Order re = Order.SAME;
        int len = doubles.length;
        for(int i = 1; i<len; i++){
            if(doubles[i] > doubles[i-1]){
                if(re == Order.DEC){
                    return Order.OUT;
                }

                re = Order.ASC;
            }else if(doubles[i] < doubles[i-1]){
                if(re == Order.ASC){
                    return Order.OUT;
                }

                re = Order.DEC;
            }

        }

        return re;
    }

    //取最大值
    public static double max(double... values){
        double max = values[0];
        for(double d : values){
            if(d > max){
                max = d;
            }
        }

        return max;
    }

    public static int max(int... values){
        int max = values[0];
        for(int d : values){
            if(d > max){
                max = d;
            }
        }

        return max;
    }


    //取最小值
    public static double min(double... values){
        double min = values[0];
        for(double d : values){
            if(d < min){
                min = d;
            }
        }

        return min;
    }

    public static int min(int... values){
        int min = values[0];
        for(int d : values){
            if(d < min){
                min = d;
            }
        }

        return min;
    }

    //求和
    public static double sum(double... values){
        double sum = 0;
        for (double value : values) {
            sum += value;
        }

        return sum;
    }

    //平均值
    public static double mean(double... values){
        return sum(values) / values.length;
    }

    //众数
    public static List<Double> mode(Double... values){
        StatisticsTable<Double> table = statistic(values);
        return table.max();
    }

    //中位数
    @Deprecated
    public static double median(double... values){
        return sum(values) / values.length;
    }

    //统计
    public static StatisticsTable<Double> statistic(Double... values){
        return StatisticsTable.createFrom(values);
    }


}
