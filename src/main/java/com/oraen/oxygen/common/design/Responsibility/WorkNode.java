package com.oraen.oxygen.common.design.Responsibility;

public interface WorkNode<T> {

    T execute(T target) throws Exception;

}
