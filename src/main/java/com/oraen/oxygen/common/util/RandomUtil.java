package com.oraen.oxygen.common.util;

import com.oraen.oxygen.common.exception.UnexpectedException;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
    private final static String zf="abcdefghijklnmopqrstuvwxyz1234567890";
    private final static ThreadLocalRandom  random = ThreadLocalRandom.current();

    public static String getRandomString(int length){
        StringBuilder r = new StringBuilder(length);
        int bound = zf.length();
        for(int i=0; i<length; i++){
            int ranIndex = random.nextInt(bound);
            r.append(zf.charAt(ranIndex));
        }
        return r.toString();
    }


    public static int getRandomNum(int min, int max){
        if(min > max){
            int temp = max;
            max = min;
            min = temp;
        }
        int span = max - min;
        int ran = random.nextInt(span + 1);
        return min + ran;
    }

    public static boolean rate(double rate){
        if(rate >= 1){
            return true;
        }else if(rate <= 0){
            return false;
        }else{
            return Math.random() < rate;
        }
    }

    public static<T> T getRandom(List<T> list){
        if(ListUtil.isEmpty(list)){
            throw new IllegalArgumentException();
        }

        int len = list.size();
        return list.get(random.nextInt(len));
    }

    public static<T> T getRandom(Map<T, Double> map){
        if(MapUtil.isEmpty(map)){
            throw new IllegalArgumentException();
        }
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
