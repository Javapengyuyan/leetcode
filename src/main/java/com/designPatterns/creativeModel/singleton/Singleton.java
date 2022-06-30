package com.designPatterns.creativeModel.singleton;

/**
 * 解释：某一个类的对象在内存中的对象只有一个
 * 目的：应用中只有一个类，防止频繁创建
 * 好处：
 * 类型：懒汉模式、饿汉模式
 * 应用场景：线程池、对话框、打印机
 *
 * 创建步骤：
 * 1、new一个不可变的对象
 * 2、不让其他人new，创建一个private的构造方法
 * 构造方法：一个类初始化时候都会自动创建一个无参构造方法，将其私有化防止别人调用
 * 3、为了让别人使用：创建一个方法返回对象。
 *
 */
public class Singleton {

    //饿汉模式
    private final static Singleton singleton = new Singleton();

    private Singleton(){}

    public Singleton instance(){
        return singleton;
    }



}
