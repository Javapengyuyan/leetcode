package com.javaBasic.concureent.QuestionDemo;

/**
 * @author: long
 * @create: 2022-04-11 15:48
 * @Description
 **/

public class RunnableTest implements Runnable {

    private int ticket = 20;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (ticket > 0){
                System.out.println("售票处卖的第几张票："+ticket--+",售票处名字:"
                        +Thread.currentThread().getName());
            }
        }
    }
}
