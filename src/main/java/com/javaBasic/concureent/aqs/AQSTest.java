package com.javaBasic.concureent.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: long
 * @create: 2022-04-07 16:02
 * @Description 自定义锁--自定义同步类
 **/
@Slf4j(topic = "AQSTest")
public class AQSTest {

    public static void main(String[] args) {
        Lock lock = new MyLock();
        new Thread(() -> {
            //log.info("t1 进入。。");
            lock.lock();
            try {
                log.info("loking。。。");
                //lock.lock();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {

                }
            } finally {
                lock.unlock();
                log.info("解锁。。。");
            }
        },"t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                log.info("loking。。。");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                log.info("解锁。。。");
            }
        }, "t2").start();

    }
}

/*
class MyLock implements Lock{

    //独占锁
    private static class MySync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0,1)){
                //加了锁，并设置owner为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override //是否持有独占锁
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition(){
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();

    @Override //加锁，不成功进入等待队列
    public void lock() {
        sync.tryAcquire(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override//加锁，可打断的
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override //加锁，不成功只尝试一次
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override//尝试加锁，带超时
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }


    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}*/
