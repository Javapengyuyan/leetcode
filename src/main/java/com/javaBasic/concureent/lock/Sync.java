package com.javaBasic.concureent.lock;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: long
 * @create: 2022-04-13 16:48
 * @Description 对比sync修饰代码块中：类和实例的方法不同
 *
 *  修饰this：只对当前变量加锁，每个变量锁单独的
 *  修饰class：整个class公用一把锁
 *  注意睡眠方法TimeUnit.SECONDS.sleep()
 *
 **/

public class Sync {

    public static void main(String[] args) {
        method4();
    }

    /**
     * 修饰this
     * 1.1、加锁一个共享实例类
     * 锁是共享的
     */
    static public void method1(){
        //只创建一个
        Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sync.thisLock();

                }
            }).start();
        }
    }

    public void thisLock(){
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName()+"线程,创建日期:"+new Date());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 1.2、加锁多个共享实例类
     * 锁是单独的
     */
    static public void method2(){
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Sync sync = new Sync();
                    sync.thisLock();
                }
            }).start();
        }

    }

    /**
     * 修饰class
     * 2.1、加锁一个共享变量
     * 锁是共享的
     */
    public static void method3(){
        Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sync.classLock();
                }
            }).start();
        }

    }
    
    public void classLock(){
        synchronized (Sync.class){
            try {
                System.out.println(Thread.currentThread().getName()+"线程,创建日期:"+new Date());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 修饰class
     * 2.2、加锁多个变量
     * 锁是共享的
     */
    public static void method4(){
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Sync sync = new Sync();
                    sync.classLock();
                }
            }).start();
        }

    }




}
