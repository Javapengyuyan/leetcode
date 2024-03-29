package com.javaBasic.concureent.thread.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: long
 * @create: 2022-02-15 09:53
 * @Description
 **/

public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread( ()->{
                /*synchronized (list){

                }*/
                list.add(Thread.currentThread().getName());
            } ).start();
        }
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}
