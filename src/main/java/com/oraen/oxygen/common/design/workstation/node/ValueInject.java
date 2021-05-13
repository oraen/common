package com.oraen.oxygen.common.design.workstation.node;

import com.oraen.oxygen.common.design.workstation.FieldNode;
import com.oraen.oxygen.common.design.workstation.node.exception.NecessityException;
import com.oraen.oxygen.common.util.JSON;
import com.oraen.oxygen.common.util.ReflectUtil;
import com.oraen.oxygen.common.util.StringUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class ValueInject<E> extends FieldNode<E> {

    public ValueInject(){
        super(Check.class);
    }

    @Override
    public void dispose(E e, Field f) throws RuntimeException {
        Check check = f.getAnnotation(Check.class);
        String value = check.value();
        Class<?> type = f.getType();
        if(!"".equals(value)){
            ReflectUtil.setFieldAuto(e, f, value);
        }
    }
}
