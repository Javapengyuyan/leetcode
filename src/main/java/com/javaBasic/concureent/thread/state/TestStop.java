package com.javaBasic.concureent.thread.state;

/**
 * @author: long
 * @create: 2022-02-13 00:17
 * @Description  测试线程停止
 *
 * 1、线程正常停止，--利用次数，不建议死循环
 * 2、建议使用标识位---设置一个标识位标识是否停止
 * 3、不要使用过期方法stop、destory等
 *
 **/

public class TestStop implements Runnable{

    //1、设置一个标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i= 0;
        while (flag){
            System.out.println("run......Thread"+i++);
        }
    }

    //2、设置一个公开方法停止线程，转换标识位
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i <= 200; i++) {
            System.out.println("main"+i);
            if (i == 150){
                testStop.stop();
                System.out.println("该线程停止了");
            }
        }


    }




}
