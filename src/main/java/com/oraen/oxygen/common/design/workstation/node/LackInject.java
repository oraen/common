package com.oraen.oxygen.common.design.workstation.node;

import com.oraen.oxygen.common.design.workstation.FieldNode;
import com.oraen.oxygen.common.design.workstation.node.exception.NecessityException;
import com.oraen.oxygen.common.design.workstation.node.exception.NormException;
import com.oraen.oxygen.common.util.JSON;
import com.oraen.oxygen.common.util.StringUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class LackInject<E> extends FieldNode<E> {

    public LackInject(){
        super(Check.class);
    }

    @Override
    public void dispose(E e, Field f) {
        Check check = f.getAnnotation(Check.class);
        String defaultValue = check.lack();
        Class<?> type = f.getType();
        try{
            Object value = f.get(e);
            if(value == null || StringUtil.isBlank(value.toString())){
                if(type == String.class){
                    f.set(e, defaultValue);
                }else if(type == Integer.class){
                    f.set(e, Integer.valueOf(defaultValue));
                }else if(type == Float.class){
                    f.set(e, Float.valueOf(defaultValue));
                }else if(type == Double.class){
                    f.set(e, Double.valueOf(defaultValue));
                }else if(type.isInstance(Map.class)){
                    f.set(e, JSON.parseMap(defaultValue));
                }else if(type.isInstance(List.class)){
                    f.set(e, JSON.parseList(defaultValue));
                }else{
                    f.set(e, JSON.parse(defaultValue, type));
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
