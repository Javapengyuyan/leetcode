package com.javaBasic.concureent.thread.state;

/**
 * @author: long
 * @create: 2022-05-07 15:45
 * @Description Interrupted功能
 **/

public class InterruptedDemo01 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = fun01();
        System.out.println("t1---start");
        Thread.sleep(1000);
        System.out.println("interrupt");
        t1.interrupt();
        System.out.println("打断标记--t1.isInterrupted:"+t1.isInterrupted());

        Thread fun = fun02();
        Thread.sleep(1000);
        System.out.println("打断线程");
        fun.interrupt();
        System.out.println("打断线程结束");

    }

    /**
     * 1、打断休眠线程
     * 注意：sleep、join、wait被打断后，会将打断标志改为false
     */
    static public Thread fun01(){
        Thread t1 = new Thread( ()->{
            try {
                Thread.sleep(5000);//
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } );
        t1.start();
        return t1;
    }

    /**
     * 2、打断正常在运行线程
     *
     * 正常线程调用fun.interrupt()并不会停止，
     * 可以调用isInterrupted()判断打断状态，从而优雅的停止线程。
     *
     */
    static public Thread fun02(){
        Thread thread = new Thread(() -> {
            while (true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted){
                    break;
                }
            }
            System.out.println("线程结束");
        });
        thread.start();
        System.out.println("线程启动");
        return thread;

    }


}
