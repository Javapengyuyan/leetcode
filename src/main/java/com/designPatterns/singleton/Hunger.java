package com.designPatterns.singleton;

/**
 * 懒汉模式
 * 1、单线程是安全的
 * 但是多线程就会碰到线程进来后都是null，变成非单例
 * 改进：方法里面加synchronized
 *
 */
public class Hunger {

    private static Hunger instance;

    private Hunger(){

    }

    public synchronized Hunger getHunger(){
        //业务代码
        //xxxxxx

        if (instance == null){
            instance = new Hunger();
        }
        return instance;
    }

    /**
     * synchronized锁的范围太广，进行优化
     *
     */

}
