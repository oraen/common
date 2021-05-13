package com.oraen.oxygen.common.design.workstation;

import com.oraen.oxygen.common.util.ReflectUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class FieldNode<E> implements BatchNode<E> {
    Class<? extends Annotation> attention;

    public FieldNode(Class<? extends Annotation> attention){
        this.attention = attention;
    }


    @Override
    public void repeat(E e) {
        for(Field f : ReflectUtil.getAllFields(e).values()){
            if(f.isAnnotationPresent(attention) || attention == Annotation.class){
                dispose(e, f);
            }
        }
    }

    public abstract void dispose(E e, Field f) throws RuntimeException;

}
