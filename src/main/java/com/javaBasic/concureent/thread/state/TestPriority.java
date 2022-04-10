package com.javaBasic.concureent.thread.state;

/**
 * @author: long
 * @create: 2022-02-14 11:01
 * @Description
 *
 * 线程优先级范围从1-10，优先级高只表示被调用的概率大，并不代表一定会被优先执行
 * 先设置优先级再启动线程
 * 性能倒置：CPU先调度优先级低的线程
 *
 **/

public class TestPriority {
    public static void main(String[] args) {
        MyPrioirty myPrioirty = new MyPrioirty();
        Thread thread1 = new Thread(myPrioirty);
        Thread thread2 = new Thread(myPrioirty);
        Thread thread3 = new Thread(myPrioirty);
        Thread thread4 = new Thread(myPrioirty);

        thread1.setPriority(5);
        thread1.start();
        thread2.setPriority(1);
        thread2.start();
        thread3.setPriority(10);
        thread3.start();
        thread4.setPriority(8);

        thread4.start();

    }
}

class MyPrioirty implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
    }
}
