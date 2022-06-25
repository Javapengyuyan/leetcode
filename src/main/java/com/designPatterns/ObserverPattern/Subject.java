package com.designPatterns.ObserverPattern;

/**
 * 抽象主题
 */
public interface Subject {

    void add(Observer observer);
    void remove(Observer observer);
    void notifyObservers();
    void operation();

}
