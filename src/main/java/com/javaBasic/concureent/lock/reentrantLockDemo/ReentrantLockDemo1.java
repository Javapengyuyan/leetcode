package com.javaBasic.concureent.lock.reentrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: long
 * @create: 2022-04-10 11:10
 * @Description 重入锁：一个线程可多次获得同一把锁。对象层面加锁
 *
 * 可中断
 * 可设置超时时间
 * 可设置成公平锁
 * 支持多个条件变量
 *
 **/

public class ReentrantLockDemo1 {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        //ReentrantLock reentrantLock = new ReentrantLock(false);//设非公平锁，true 公平锁
        try {
            lock.lock();
            System.out.println("进入主方法");
            m1();
        }finally {
            lock.unlock();
            System.out.println("主方法释放锁");
        }


    }

    static public void m1(){
        try {
            lock.lock();
            System.out.println("进入m1");
        }finally {
            lock.unlock();
            System.out.println("m1释放锁");
        }
    }


}
