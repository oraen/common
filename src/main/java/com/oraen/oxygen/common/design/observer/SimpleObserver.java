package com.oraen.oxygen.common.design.observer;

public abstract class SimpleObserver implements Observer{
    protected Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }



}
