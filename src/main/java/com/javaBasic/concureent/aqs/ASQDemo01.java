package com.javaBasic.concureent.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: long
 * @create: 2022-05-22 16:27
 * @Description AQS：阻塞式锁和相关的同步器框架
 *
 * JUC并发工具--基于AQS。
 **/

public class ASQDemo01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();


    }

}
