package com.oraen.oxygen.common.math.ran;

import com.oraen.oxygen.common.model.enumeration.math.Order;

import java.util.Random;

//静态工具类 不应该考虑用户的拓展和定制需求
public class RandomUtil {

    private static final Random random = RandomConfig.getDefaultRandomSource();


    //返回min到max中的随机数 包括两者
    public static int ranInt(int min, int max){
        return random.nextInt(max) % (max - min + 1) + min;
    }

    //返回 0到bound-1 中的随机数
    public static int ranInt(int bound){
        return random.nextInt(bound);
    }

    public static int ranInt(){
        return random.nextInt();
    }

    public static double ranNumIn(double... nums){
        int len = nums.length;
        return nums[ranInt(len)];
    }



}
