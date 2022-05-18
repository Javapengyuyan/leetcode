package com.javaBasic.concureent.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author: long
 * @create: 2022-05-17 12:10
 * @Description AtomicStampedReference只是时间戳，AtomicMarkableReference是否改变过
 **/
@Slf4j
public class AtomicDemo04 {
    public static void main(String[] args) {
        GarbageBag bag = new GarbageBag("装满了辣鸡");
        AtomicMarkableReference<GarbageBag> amr = new AtomicMarkableReference(bag,true);
        GarbageBag reference = amr.getReference();
        log.info("原来袋子：{}",reference.toString());

        //保洁阿姨更换袋子
        new Thread(()->{
            GarbageBag amrReference = amr.getReference();
            amrReference.setDesc("空袋子");
            boolean b = amr.compareAndSet(bag, bag, true, false);
            log.info("保洁阿姨更换袋子：{}",b);
        }).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean compareAndSet = amr.compareAndSet(bag, new GarbageBag("新袋子"), true, true);
        log.info("更换袋子：{}",compareAndSet);
        log.info("更换袋子后：{}",amr.getReference().toString());


    }
}

class GarbageBag{
    private String desc;

    public GarbageBag(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "GarbageBag{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
