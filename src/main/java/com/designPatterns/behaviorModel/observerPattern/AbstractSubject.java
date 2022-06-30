package com.designPatterns.behaviorModel.observerPattern;

import java.util.Vector;

/**
 * @author: long
 * @create: 2022-06-23 18:22
 * @Description
 **/

public class AbstractSubject implements Subject{

    private Vector<Observer> observers = new Vector<>();

    @Override
    public void add(com.designPatterns.behaviorModel.observerPattern.Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(com.designPatterns.behaviorModel.observerPattern.Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o :observers) {
            o.update();
        }
    }

    @Override
    public void operation() {

    }
}
