package com.javaBasic.concureent.lock.threadActive;

/**
 * @author: long
 * @create: 2022-05-09 22:40
 * @Description 线程活跃性：三种中的死锁
 *
 *  法一：
 *  Terminal输入：jps查看运行的线程
 *  在输入线程号：jstack 28812 查看是否有死锁
 *
 *  法二：
 *  jconsol工具
 *
 **/

public class DeadLockDemo01 {
    public static void main(String[] args) {
        method1();

    }

    private static void method1() {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (o1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (o2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){

                }
            }
        });
        thread1.start();
        thread2.start();

    }
}
