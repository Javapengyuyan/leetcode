package com.javaBasic.concureent;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.io.FileReader;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: long
 * @create: 2022-04-08 20:08
 * @Description
 **/

public class Test {

    static boolean flag = true;
    static private volatile int stopNum = 0;

    public static void main(String[] args) {
        /*try {
            FileReader fileReader = new FileReader("");
            fileReader.read();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //new Thread( ()-> FileReader.read(Constants.MP4_URL).start());
        BlockingDeque<Object> blockingDeque = new LinkedBlockingDeque<>();
        BlockingQueue<Object> delayQueue = new DelayQueue();
        //判断线程是否有锁
        Thread.holdsLock(blockingDeque);
        yieldTest yieldTest = new yieldTest();
        new Thread(yieldTest,"a").start();
        new Thread(yieldTest,"b").start();*/
        //测试停止线程
        testStop testStop = new testStop();
        new Thread(testStop).start();
        int i=0;
        while (true){
            System.out.println("线程外面："+i);
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (stopNum == 10){
                flag = false;
                return;
            }
        }


    }

    public void countAdd(){
        stopNum++;
    }

    static class testStop implements Runnable{
        @Override
        public void run() {
            //int i=0;
            while (flag){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程中："+stopNum);
                stopNum++;
            }

        }
    }

    static class yieldTest implements Runnable{
        @Override
        public void run() {
            System.out.println("运行线程"+Thread.currentThread().getName());
            Thread.yield();
            System.out.println("结束线程"+Thread.currentThread().getName());
        }
    }


}
