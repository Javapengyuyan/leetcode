package com.javaBasic.concureent.aqs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: long
 * @create: 2022-07-19 09:31
 * @Description
 **/

public class ThreadQueue extends AbstractQueuedSynchronizer {

    public void test(){
        ReentrantLock reentrantLock = new ReentrantLock();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(100);


    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }
}
