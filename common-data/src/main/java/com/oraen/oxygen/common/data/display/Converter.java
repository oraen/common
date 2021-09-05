package com.oraen.oxygen.common.data.display;

public interface Converter<T, S> {
    S convert(T t);

}
