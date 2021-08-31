package com.oraen.oxygen.common.math.ran;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomConfig {

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static ThreadLocalRandom getDefaultRandomSource(){
        return random;
    }
}
