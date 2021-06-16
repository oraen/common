package com.oraen.oxygen.common.json;

import com.oraen.oxygen.common.exception.NoSolutionException;
import com.oraen.oxygen.common.exception.OutOfTaskException;
import com.oraen.oxygen.common.util.StringUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SuppressWarnings({"unchecked"})
public abstract class Creator<T> {

    protected final Class<T> concern;

    protected Creator<?> first;

    protected Creator<?> next;


    public Creator(){
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        this.concern = (Class<T>) actualTypeArguments[0];
        this.first = this;
    }

    public abstract String creatorJSON(T t);

    public String creator(Object o){

        try{
            if(concern.isInstance(o)){
                return creatorJSON((T)o);
            }

            throw new OutOfTaskException();
        }catch (OutOfTaskException e){
            if(next != null){
                return next.creator(o);
            }

            throw new NoSolutionException("职责链中无法解决的类型 " + o.getClass().getName());
        }
    }


    public Creator<?> append(Creator<?> next){
        this.next = next;
        if(next != null){
            next.first = this.first;
        }
        return next;

    }

    public static void closeOff(StringBuilder sb, char end){
        if(StringUtil.getAt(sb.toString(), -1) == ','){
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(end);

    }

    public Class<T> getConcern() {
        return concern;
    }





}
