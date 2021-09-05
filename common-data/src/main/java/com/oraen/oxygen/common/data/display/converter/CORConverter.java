package com.oraen.oxygen.common.data.display.converter;

import com.oraen.oxygen.common.data.display.Converter;

//COF: Chain of Responsibility
public abstract class CORConverter<T, S> implements Converter<T, S> {

    CORConverter<? super T, S> next;

    @Override
    public S convert(T t) {
        if(judge(t)){
            return convert0(t);
        }

        if(next != null){
            return next.convert(t);
        }

        return null;
    }

    public CORConverter<? super T, S> getNext() {
        return next;
    }

    public void setNext(CORConverter<? super T, S> next) {
        this.next = next;
    }

    public CORConverter<? super T, S> add(CORConverter<? super T, S> next) {
        this.next = next;
        return next;
    }

    public abstract boolean judge(T t);

    public abstract S convert0(T t);


}
