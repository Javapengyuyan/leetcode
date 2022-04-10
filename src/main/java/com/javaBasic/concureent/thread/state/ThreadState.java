package com.javaBasic.concureent.thread.state;

/**
 * @author: long
 * @create: 2022-02-14 09:31
 * @Description
 **/

public class ThreadState {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程休息次数:"+i);
            }
            System.out.println("//////");
        });
        //1、查看状态
        Thread.State state = thread.getState();
        System.out.println(state);//new
        //2、启动线程
        thread.start();
        state = thread.getState();
        System.out.println(state);
        while (state != Thread.State.TERMINATED){//线程不终止就一直输出状态
            Thread.sleep(100);
            state = thread.getState();
            System.out.println("不终止前状态："+state);
        }
        //线程一旦死亡不能再启动

    }

}
