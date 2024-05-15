package com.javaBasic.concureent.test;

/**
 * @author: long
 * @create: 2023-01-31 10:57
 * @Description 交替打印线程
 **/

public class PrintTest {

    //static Integer i = 1;
    private static int i;
    private static final Object lock = new Object();
    public static void main(String[] args) {
    //public static void aa(String[] args) {
        System.out.println("lock:"+lock);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 100){
                    synchronized (lock){
                        if ( (i & 1) == 0){
                            System.out.println("偶数："+ i++);
                        }
                    }

                }
            }
        },"").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 100){
                    synchronized (lock){
                        if ( (i & 1) == 1 ){
                            System.out.println("奇数："+ i++);
                        }
                    }
                }
            }
        },"").start();

    }

    private static int count;

    private static final Object object = new Object();

    //public static void main(String[] args) {
    public static void a(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }

            }
        }, "偶数线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }

            }
        }, "奇数线程").start();
    }


}
