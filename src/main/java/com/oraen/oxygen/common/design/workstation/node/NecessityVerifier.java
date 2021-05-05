package com.oraen.oxygen.common.design.workstation.node;

import com.oraen.oxygen.common.design.workstation.FieldNode;
import com.oraen.oxygen.common.design.workstation.node.exception.NecessityException;
import com.oraen.oxygen.common.design.workstation.node.exception.NormException;
import com.oraen.oxygen.common.util.StringUtil;

import java.lang.reflect.Field;

public class NecessityVerifier<E> extends FieldNode<E>{

    public NecessityVerifier(){
        super(Check.class);
    }

    @Override
    public void dispose(E e, Field f) {
        Check check = f.getAnnotation(Check.class);
        boolean necessity = check.necessity();
        if(necessity){
            try{
                Object value = f.get(e);
                if(value == null || StringUtil.isBlank(value.toString())){
                    throw new NecessityException(e, f);
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }

        }
    }

}
