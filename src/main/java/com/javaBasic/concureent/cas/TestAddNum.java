package com.javaBasic.concureent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: long
 * @create: 2022-04-12 23:25
 * @Description
 **/

public class TestAddNum {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static int total = 0;
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    //使用total会出现相同值得情况
                    while (total < 10000){
                        System.out.println(Thread.currentThread().getName()+"："+total++);
                    }
                    //优化一：互斥锁。不用，效率太慢
                    synchronized (TestAddNum.class){
                        System.out.println(Thread.currentThread().getName()+"："+total++);
                    }
                    //优化二：高级办法使用原子自增。底层依据cas原理
                     while (atomicInteger.get() < 1000){
                        System.out.println(Thread.currentThread().getName()+"："+atomicInteger.incrementAndGet());
                    }

                }
            }).start();
        }

    }
}
