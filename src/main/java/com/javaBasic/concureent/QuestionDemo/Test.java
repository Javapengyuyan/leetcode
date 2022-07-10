package com.javaBasic.concureent.QuestionDemo;

/**
 * @author: long
 * @create: 2022-04-11 15:47
 * @Description
 **/

public class Test {

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        /**
         * runnableTest没有start方法来直接启动
         * 而继承thread类的方法则有，如：new ThreadTest().start();
         */
        /*Thread t1 = new Thread(runnableTest, "线程1");
        Thread t2 = new Thread(runnableTest, "线程2");
        Thread t3 = new Thread(runnableTest, "线程3");
        t1.start();
        t2.start();
        t3.start();*/


        ThreadTest threadTest = new ThreadTest();
        threadTest.run();
        //new ThreadTest().start();
        /**
         * 是不是Thread没有多线程并行操作同一个资源体的能力呢?
         */
        /*Thread thread1 = new Thread(threadTest, "线程1");
        Thread thread2 = new Thread(threadTest, "线程2");
        Thread thread3 = new Thread(threadTest, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();*/
        //todo 有什么用？哪里用
        Thread.interrupted();

    }

}
