package com.oraen.oxygen.common.math.ran;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class AdvRandomUtil {

    private static final ThreadLocalRandom random = RandomConfig.getDefaultRandomSource();


    public static boolean rate(double rate){
        return random.nextDouble() < rate;
    }

    public static<T> T getRandom(List<T> list){
        int len = list.size();
        return list.get(random.nextInt(len));
    }

    public static<T> T getRandom(Map<T, Double> map){
        double sum = 0;
        for(Map.Entry<T, Double> entry: map.entrySet()){
            sum += entry.getValue();
        }
        double ran = random.nextDouble(sum);

        T re = null;
        for(Map.Entry<T, Double> entry: map.entrySet()){
            ran -= entry.getValue();
            re = entry.getKey();
            if(ran <= 0){
                return re;
            }
        }
        return re;
    }
}
