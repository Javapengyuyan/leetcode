package com.javaBasic.concureent.thread.state;

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

        /**
         * 2、有参数join，有时间限制等待
         * 入参等待时间和线程休眠时间，两者会取最小值。
         */
        try {
            Thread thread1 = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            long strat = System.currentTimeMillis();
            thread1.start();
            System.out.println("线程启动");
            thread1.join(5000);
            long end = System.currentTimeMillis();
            System.out.println("结束："+ (end-strat)/1000 );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
