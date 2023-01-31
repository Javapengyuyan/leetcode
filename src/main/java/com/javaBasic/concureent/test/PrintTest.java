package com.javaBasic.concureent.test;

/**
 * @author: long
 * @create: 2023-01-31 10:57
 * @Description 交替打印线程
 **/

public class PrintTest {

    public static void main(String[] args) {
        int i = 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("奇数："+i);
            }
        }).start();

    }

}
