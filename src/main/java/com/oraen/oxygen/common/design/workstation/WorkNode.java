package com.oraen.oxygen.common.design.workstation;

public interface WorkNode<T> {

    void execute(T target) throws RuntimeException;

}
