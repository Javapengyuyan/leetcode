package com.designPatterns.ObserverPattern;

/**
 * @author: long
 * @create: 2022-06-23 23:16
 * @Description
 **/

public class ObserverOne implements Observer {
    @Override
    public void update() {
        System.out.println("第一个观察者收到通知更新状态");
    }
}

class ObserverTwo implements Observer {
    @Override
    public void update() {
        System.out.println("第二个观察者收到通知更新状态");
    }
}
