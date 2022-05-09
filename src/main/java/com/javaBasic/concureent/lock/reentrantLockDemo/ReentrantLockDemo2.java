package com.javaBasic.concureent.lock.reentrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: long
 * @create: 2022-05-08 15:48
 * @Description 测试reentrantLock打断特性
 **/

public class ReentrantLockDemo2 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread( ()->{
            try {
                System.out.println("尝试获取锁");
                /**
                 * 如果用lock.lock则不能打断
                 */
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("尝试获取锁失败");
                return;
            }
            try {
                System.out.println("获得了锁");
            }finally {
                lock.unlock();
                System.out.println("释放了锁");
            }
        });
        lock.lock();
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("打断t1");
        t1.interrupt();


    }
}
