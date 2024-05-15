package com.javaBasic.concureent.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: long
 * @CreateTime: 2024-03-25 21:15
 * @Description:
 * @Version: 1.0
 */
public class ThreadPoolExecuteTest {

    public static AtomicInteger sum = new AtomicInteger(0);
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecute = new ThreadPoolExecutor( 5, 10, 10,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 100000; i++) {
            threadPoolExecute.execute(()->{
                //sum.incrementAndGet();
                //sum.set(sum.get() + 1);
                sum.getAndAdd(2);
            });

        }
        System.out.printf("总和:"+sum);

    }

}
