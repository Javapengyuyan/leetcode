package com.javaBasic.concureent.thread;

/**
 * @author: long
 * @create: 2022-05-11 18:47
 * @Description volatile修饰后，会增加内存屏障,保证可见性
 *              但是不能保证原子性，比如：i++两个线程，读取指令进行交错。synchronized可以
 *
 **/

public class VolatileDemo {

    public volatile boolean ready = false;
    public Integer num = 0;

    public static void main(String[] args) {

    }

    /**
     *写屏障 ：
     *  可见性：会将共享变量前的值一起同步到主内存
     *  有序性：保证屏障前代码的有序
     */
    public void method01(){
        num = 2;
        ready = true;//ready附带写屏障
        //写屏障
    }

    /**
     *读屏障 ：
     *  可见性：会将共享变量之后，对共享变量值从主内存读取，加载最新数据
     *  有序性：保证屏障后代码有序
     */
    public void method02(){
        if (ready){//ready附带读屏障
            num+=2;
        }
    }

}
