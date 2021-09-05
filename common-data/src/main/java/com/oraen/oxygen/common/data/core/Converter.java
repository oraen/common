package com.oraen.oxygen.common.data.core;

public interface Converter<T, S> {
    S convert(T t);

}
