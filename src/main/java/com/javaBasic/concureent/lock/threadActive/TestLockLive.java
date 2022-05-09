package com.javaBasic.concureent.lock.threadActive;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: long
 * @create: 2022-05-09 23:20
 * @Description 活锁：两个线程互相改变对方结束条件，最后谁也无法结束
 *
 * 解决方法：修改一下睡眠时间，让他们错开
 *
 **/

@Slf4j(topic = "TestLockLive")
public class TestLockLive {

    static volatile int count = 10;
    public static void main(String[] args) {
        //比如：一个加，一个减，造成活锁

        Thread thread1 = new Thread(()->{
            while (count>0){
                count--;
                try {
                    Thread.sleep(1000);
                    log.debug("count:{}",count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(()->{
            while (count <20){
                count++;
                try {
                    Thread.sleep(200);
                    log.debug("count:{}",count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

    }

}
