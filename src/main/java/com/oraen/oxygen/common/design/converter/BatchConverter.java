package com.oraen.oxygen.common.design.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface BatchConverter<T, S> extends Converter<Collection<? extends T>, List<S>> {

    S from(T t);

    @Override
    default List<S> convert(Collection<? extends T> from){
        List<S> re = new ArrayList<>(16);
        for(T t : from){
            re.add(from(t));
        }
        return re;
    }
}
