package com.oraen.oxygen.common.design.workstation.node;

import com.oraen.oxygen.common.design.workstation.FieldNode;
import com.oraen.oxygen.common.design.workstation.node.exception.NormException;

import java.lang.reflect.Field;

public class NormVerifier<E> extends FieldNode<E> {

    public NormVerifier(){
        super(Check.class);
    }

    @Override
    public void dispose(E e, Field f) {
        Check check = f.getAnnotation(Check.class);
        String regexp = check.norm();
        if(! ".*".equals(regexp)){
            try{
                String value = f.get(e).toString();
                if(!value.matches(regexp)){
                    throw new NormException(e, f);
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
