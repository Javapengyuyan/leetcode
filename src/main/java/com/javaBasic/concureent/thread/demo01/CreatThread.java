package com.javaBasic.concureent.thread.demo01;

import java.util.concurrent.Callable;

public class CreatThread extends Thread implements Runnable, Callable {

    //实现方法：
    //1、继承thread类
    //2、实现runnable接口
    //3、实现callable接口
    //注意：线程开启不一定立即执行，由CPU调度

    @Override
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println("我在看代码!!!"+i);
        }
    }

    //thread run 和 start的差异
    public static void main(String[] args) {

        CreatThread creatThread = new CreatThread();
        //两者的区别
        //creatThread.run();
        creatThread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程！！！"+i);
        }

    }


    @Override
    public Object call() throws Exception {

        return null;
    }
}
