package com.oraen.oxygen.common.data.auto;

public class AutoTransitionException extends RuntimeException {

    public AutoTransitionException(Object value, Class<?> target){
        super("无法将类型为" + value.getClass().getCanonicalName() + "的值 " + value + " 转化为类型" + target.getCanonicalName());
    }
}
