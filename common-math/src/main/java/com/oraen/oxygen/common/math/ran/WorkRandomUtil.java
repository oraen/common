package com.oraen.oxygen.common.math.ran;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WorkRandomUtil {

    private static final Random random = RandomConfig.getDefaultRandomSource();

    private final static char[] charEnum ="abcdefghijklnmopqrstuvwxyz1234567890".toCharArray();

    public static String getRandomString(int length){
        StringBuilder r = new StringBuilder(length);
        int bound = charEnum.length;
        for(int i=0; i<length; i++){
            int ranIndex = random.nextInt(bound);
            r.append(charEnum[ranIndex]);
        }
        return r.toString();
    }

}
