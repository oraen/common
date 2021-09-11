package com.oraen.oxygen.common.model.exception;

public class TypeTransitionException extends RuntimeException {
    public TypeTransitionException(Object data, Class<?> type){
        super((data == null ? "null" : "数据类型为" + data.getClass().getName() + "的值 " + data )+ "无法转化为目标类型:" + type.getName());
    }
}
