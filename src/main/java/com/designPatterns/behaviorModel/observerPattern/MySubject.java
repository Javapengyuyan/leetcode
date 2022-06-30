package com.designPatterns.behaviorModel.observerPattern;

/**
 * @author: long
 * @create: 2022-06-23 23:26
 * @Description
 * 观察者模式什么时候使用
 * 一个对象状态改变，所有有依赖关系的对象都会收到广播通知
 *
 * 观察者模式的优点
 * 观察者和目标是抽象耦合的，低耦合，是一套触发机制
 *
 * 观察者模式的缺点
 * ①如果一个目标中依赖的直接观察者和间接观察者有很多的话，通知所有观察者需要花费很多时间
 * ②如果观察者和被观察者之间有循环依赖的话，可能会出现循环调用，导致系统崩溃
 * ③观察者无法知道目标状态是如何变化的，只能知道目标状态发生了改变
 * 观察者模式的注意事项
 * ①JAVA中已经有了观察者模式的支持类，可以直接使用
 * ②避免循环调用
 * ③如果顺序执行观察者的更新方法，某一观察者错误会导致系统卡住，一般采用异步方式。
 **/

public class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("具体目标状态改变");
        System.out.println("正在通知观察者...");
        notifyObservers();
        System.out.println("通知完毕!");
    }

    public static void main(String[] args) {
        MySubject mySubject = new MySubject();
        mySubject.add(new ObserverOne());
        mySubject.add(new ObserverTwo());
        mySubject.operation();

    }
}
