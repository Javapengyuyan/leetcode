package com.javaBasic.concureent.lock.executeSeq;

/**
 * @author: long
 * @create: 2022-05-10 20:30
 * @Description 如何让两个线程按照指定顺序执行：1、使用wait-notify
 *
 **/

public class WaitNotifyDemo {

    static boolean execute = false;

    public static void main(String[] args) {
        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock){
                System.out.println("先执行的lock1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (!execute){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("执行线程1");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock){
                execute = true;
                System.out.println("执行线程2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
            }
        });

        thread1.start();
        thread2.start();

    }

}
