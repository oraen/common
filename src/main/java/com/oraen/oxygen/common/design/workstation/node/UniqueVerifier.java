package com.oraen.oxygen.common.design.workstation.node;

import com.oraen.oxygen.common.design.workstation.FieldNode;
import com.oraen.oxygen.common.design.workstation.WorkNode;
import com.oraen.oxygen.common.util.CommonUtil;
import com.oraen.oxygen.common.util.ListUtil;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UniqueVerifier<E> implements WorkNode<Collection<E>> {
    @Override
    public void execute(Collection<E> target) throws RuntimeException {
        if(target.size() > 0){
            Field[] fields = ListUtil.getContentType(target).getDeclaredFields();
            try{
                for(Field field : fields){
                    Check check = field.getAnnotation(Check.class);
                    if(check != null){
                        field.setAccessible(true);
                        if(check.unique()){
                            Set<Object> set = new HashSet<Object>();
                            for(Object o : target){
                                Object value = field.get(o);
                                if(! set.add(value)){
                                    throw new RuntimeException("发现重复数据");
                                }
                            }

                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
