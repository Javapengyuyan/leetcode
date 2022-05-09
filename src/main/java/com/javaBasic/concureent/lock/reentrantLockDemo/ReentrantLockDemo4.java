package com.javaBasic.concureent.lock.reentrantLockDemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static org.apache.tomcat.jni.Time.sleep;

/**
 * @author: long
 * @create: 2022-05-09 09:37
 * @Description 锁等待进入休息室，被唤醒
 **/
@Slf4j
public class ReentrantLockDemo4 {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        try {
            lock.lock();
            //进入休息等待
            c1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        c1.signal();//单独唤醒
        c1.signalAll();//全部唤醒
    }

    /**
     * 模拟一个等烟、一个等外卖
     */
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;
    static ReentrantLock ROOM = new ReentrantLock();
    static Condition waitCigaretteSet = ROOM.newCondition();

    public void method01(){
        new Thread(()->{
            ROOM.lock();
           try {
               while (!hasCigarette){
                   log.debug("没烟，先歇会");
                   try {
                       ROOM.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               log.debug("可以开始干活了");
           }finally {
               ROOM.unlock();
           }

            /*
           synchronized (room){
               log.debug("有没有烟:{}",hasCigarette);
               while (!hasCigarette){
                   log.debug("没烟，先歇会");
                   try {
                       room.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               log.info("有没有烟:{}",hasCigarette);
               if (hasCigarette){
                   log.debug("可以开始干活了");
               }else {
                   log.debug("没干成活。。");
               }
           }*/
        },"小南").start();

        new Thread(()->{
            synchronized (room){
                Thread thread = Thread.currentThread();
                log.debug("外卖送到没:{}",hasTakeout);
                while (!hasTakeout){
                    log.debug("没外卖，先歇会");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("外卖送到没:{}",hasTakeout);
                if (hasTakeout){
                    log.debug("可以开始干活了");
                }else {
                    log.debug("没干成活。。");
                }
            }
        },"小女").start();

        sleep(1);
        new Thread(()->{
            ROOM.lock();
            try {
                hasCigarette = true;
                waitCigaretteSet.signal();
            }finally {
                ROOM.unlock();
            }
            /*synchronized (room){
                hasTakeout = true;
                log.debug("外卖到了噢！");
                room.notifyAll();
            }*/

        },"送外卖的").start();

    }

}
