package com.javaBasic.concureent.thread.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: long
 * @create: 2022-02-15 13:18
 * @Description
 **/

public class TestJUC {
    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList<String > list = new CopyOnWriteArrayList();
        for (int i = 0; i < 1000; i++) {
            new Thread( ()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(100);
        System.out.println(list.size());

    }

}
