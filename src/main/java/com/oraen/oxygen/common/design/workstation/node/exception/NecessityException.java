package com.oraen.oxygen.common.design.workstation.node.exception;

import java.lang.reflect.Field;

public class NecessityException extends ValidateFailException {
    public NecessityException(Object o, Field f){
        super(o, f, "按照Check的necessity约束，类 " + o.getClass().getName() + " 的字段 " + f.getName() + " 不能为空");

    }
}
