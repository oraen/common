package com.oraen.oxygen.common.design.observer;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void publish();
}
