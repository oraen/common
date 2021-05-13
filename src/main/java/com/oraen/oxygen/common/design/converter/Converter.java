package com.oraen.oxygen.common.design.converter;

public interface Converter<T, S> {

    S convert(T form);

}
