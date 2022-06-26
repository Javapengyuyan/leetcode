package com.javaBasic.concureent.lock.executeSeq;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: long
 * @create: 2022-05-10 22:46
 * @Description
 **/
@Slf4j
public class SeqDemo01 {
    public static void main(String[] args) {
        method03();
    }

    static public void method01(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread t1 = new Thread(() -> {
            log.info("t1");
        });
        Thread t2 = new Thread(() -> {
            log.info("t2");
        });
        Thread t3 = new Thread(() -> {
            log.info("t3");
        });
        for (int i = 0; i < 3; i++) {
            executorService.execute(t1);
            executorService.execute(t2);
            executorService.execute(t3);
            Future<?> submit = executorService.submit(t1);
            executorService.submit(t2);
            executorService.submit(t3);
        }
        executorService.shutdown();
    }

    static public void method02(){
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.signal();

    }

    static public void method03(){
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();
        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (queue.size() != 0){
            Object poll = null;
            try {
                poll = queue.poll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("输出"+poll);
        }
        System.out.println("结束");


    }

}
