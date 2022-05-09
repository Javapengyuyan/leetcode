package com.javaBasic.concureent.lock.reentrantLockDemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: long
 * @create: 2022-05-08 16:02
 * @Description 测试锁超时
 **/
@Slf4j(topic = "ReentrantLockDemo3")
public class ReentrantLockDemo3 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(()->{
            try {
                log.info("尝试获取锁");
                boolean tryLock = lock.tryLock(1, TimeUnit.SECONDS);
                log.info("尝试获取锁结果："+tryLock);
                if (!tryLock ){
                    log.info("获取不到锁");
                    return;
                }
            }catch (Exception e){
                log.info("获取锁失败");
                return;
            }
            try {
                log.info("获取成功");
            }catch (Exception e){
                log.info("获取锁失败");
                return;
            }finally {
                lock.unlock();
                log.info("释放锁");
            }

        });
        lock.lock();
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();

    }
}
