package com.oraen.oxygen.common.design.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class SimpleSubject implements Subject{
    protected Set<Observer> observers = new HashSet<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void publish() {
        for(Observer o : observers){
            o.update();
        }
    }
}
