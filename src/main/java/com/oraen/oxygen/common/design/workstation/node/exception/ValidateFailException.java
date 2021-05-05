package com.oraen.oxygen.common.design.workstation.node.exception;

import java.lang.reflect.Field;

public class ValidateFailException extends RuntimeException {

    protected Object target;

    protected Field targetField;

    public Object getTarget() {
        return target;
    }

    public Field getTargetField() {
        return targetField;
    }

    public ValidateFailException(){
        ;
    }


    public ValidateFailException(Object o, Field f, String message){
        super(message);
        this.target = o;
        this.targetField = f;
    }
}
