package com.zjh.javademo.pattern.observer;

public interface ISubject {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyAllObserver();
}
