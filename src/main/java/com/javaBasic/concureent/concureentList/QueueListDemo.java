package com.javaBasic.concureent.concureentList;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: long
 * @create: 2022-05-11 11:10
 * @Description 并发队列
 **/

public class QueueListDemo {
    static LinkedBlockingQueue queue = new LinkedBlockingQueue<>();
    public static void main(String[] args) {
        method1();

    }

    static public void method1(){
        try {
            //从队列中取值，如果队列中无值，线程会一直阻塞，直到队列中有值
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public void method2(){
        try {
            //队列中放入值，如果队列中无空间，线程会一直阻塞
            queue.put("object");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public void method3(){
        //队列中放入值，成功为ture，失败false
        boolean add = queue.add("object");
    }

    static public void method4(){
        //队列头元素移出
        Object poll = queue.poll();
    }

}
