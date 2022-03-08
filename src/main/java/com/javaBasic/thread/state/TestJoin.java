package com.javaBasic.thread.state;

/**
 * @author: long
 * @create: 2022-02-13 21:40
 * @Description
 **/

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip大哥来了"+i);
        }

    }

    public static void main(String[] args) {
        /**
         * 前200个线程并行
         * join后插队，由vip大哥先运行
         */
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        for (int i = 0; i < 500; i++) {
            System.out.println("main"+i);
            if (i==200){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
