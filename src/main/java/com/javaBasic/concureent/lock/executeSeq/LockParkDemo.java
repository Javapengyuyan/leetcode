package com.javaBasic.concureent.lock.executeSeq;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: long
 * @create: 2022-05-10 20:53
 * @Description  LockSupport.park()方法demo
 **/

@Slf4j
public class LockParkDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            //暂停当前线程---查看是否要休息，有干粮就继续前进没有就休息
            LockSupport.park();
            log.info("线程1");
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            log.info("线程2");
            //恢复刚才暂停的线程---类似于补充一份干粮
            LockSupport.unpark(thread1);
        });
        thread2.start();


    }

}
