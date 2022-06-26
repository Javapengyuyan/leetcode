package com.javaBasic.concureent.QuestionDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: long
 * @create: 2022-05-05 21:24
 * @Description 测试sleep不会释放锁，wait释放锁
 **/

public class SleepTest {

    public static void main(String[] args) {
        Object lock = new Object();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable runnable = ()-> {
            synchronized (lock){
                try {
                    System.out.println(Thread.currentThread().getName()+"锁上了");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"释放了锁");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable waitRunnable = new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        System.out.println(Thread.currentThread().getName()+"锁上了");
                        wait(1000);
                        System.out.println(Thread.currentThread().getName()+"释放了锁");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            //executorService.execute(runnable);
            executorService.execute(waitRunnable);
        }
        executorService.shutdown();

    }

}
