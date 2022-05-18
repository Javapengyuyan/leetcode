package com.javaBasic.concureent.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: long
 * @create: 2022-05-17 10:39
 * @Description     CAS经典ABA问题
 **/
@Slf4j(topic = "AtomicDemo03")
public class AtomicDemo03 {
    static AtomicStampedReference<String> sr = new AtomicStampedReference<>("A",0);
    public static void main(String[] args) {

        String reference = sr.getReference();
        int stamp = sr.getStamp();
        log.info("主线程初始reference:{},stamp{}",reference,stamp);
        other();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("other修改后尝试修改主线程reference:{},stamp{}",reference,stamp);
        boolean cas = sr.compareAndSet(reference, "B", stamp, stamp + 1);
        log.info("主线程修改:"+cas);

    }

    static public void other(){
        new Thread(()->{
            String reference = sr.getReference();
            int stamp = sr.getStamp();
            boolean b = sr.compareAndSet(reference, "B", stamp, stamp + 1);
            log.info("other第一次修改reference:{},stamp{},{}:",reference,stamp,b);
        }).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            String reference = sr.getReference();
            int stamp = sr.getStamp();
            boolean a = sr.compareAndSet(reference, "A", stamp, stamp + 1);
            log.info("other第二次修改reference:{},stamp{},{}:",reference,stamp,a);
        }).start();

    }

}
