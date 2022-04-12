package com.javaBasic.concureent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: long
 * @create: 2022-04-12 18:02
 * @Description
 **/

public class CASTest {
    public static void main(String[] args) {
        /*AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.get();
        atomicInteger.incrementAndGet();
        //期望，更新
        System.out.println( atomicInteger.compareAndSet(2022,2023) );*/

        /**
         * java无法操作内存
         * c++可以操作内存
         * 用java调用c++ native
         * java后门，通过Unsafe类来操作内存
         */
        //cas无锁解决


    }
}
