package com.designPatterns.singleton;

/**
 * 懒汉模式（线程安全的）
 */
public class Hunger02 {

    //为什么要加 volatile 关键字
    private static volatile Hunger02 hunger02;

    private Hunger02(){}

    public Hunger02 getHunger02(){

        if (hunger02 == null ){
            synchronized (Hunger02.class){
                if (hunger02 == null){
                    hunger02 = new Hunger02();
                }

            }
        }
        return hunger02;
    }


}
