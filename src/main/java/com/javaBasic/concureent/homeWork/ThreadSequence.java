package com.javaBasic.concureent.homeWork;

import java.util.concurrent.*;

/**
 * @author: long
 * @create: 2022-04-15 11:31
 * @Description 让线程按一定顺序执行
 *
 * join方法测试
 *
 **/

public class ThreadSequence {
    public static void main(String[] args) {
        method4();

    }

    /**
     * 法一：join：调用线程等待join执行完才继续执行
     */
    static public void method1(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println("线程2");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程3");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }



    /**
     * 法二：使用 CountDownLatch
     */
    static public void method2(){
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        CountDownLatch countDownLatch3 = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1");
                //countDownLatch1.countDown();
                countDownLatch2.countDown();
                countDownLatch3.countDown();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    countDownLatch2.await();
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2");
                countDownLatch3.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程3");

            }
        }).start();
    }

    /**
     * 法三：使用单例线程池
     */
    static public void method3(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程3");
            }
        });
        executorService.submit(thread2);
        executorService.submit(thread1);

        executorService.submit(thread3);
        executorService.shutdown();
    }

    /**
     * 法四：使用cyclicBarrier
     * 回环栅栏
     */
    static public void method4(){
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1");
                try {
                    Thread.sleep(1500);
                    cyclicBarrier1.await();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier1.await();
                    System.out.println("线程2");
                    Thread.sleep(1500);
                    cyclicBarrier2.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier2.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程3");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
