package com.oraen.oxygen.common.design.workstation.node.exception;

import com.oraen.oxygen.common.design.workstation.node.Check;

import java.lang.reflect.Field;

public class NormException extends ValidateFailException {


    public NormException(Object o, Field f){
        super(o, f, o.getClass().getName() + "类中发现对象的字段 " + f.getName() + " 不符合注解Check中的Norm正则表达式 " + f.getAnnotation(Check.class).norm()+" 的要求");
    }

}
