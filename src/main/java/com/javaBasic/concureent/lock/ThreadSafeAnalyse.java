package com.javaBasic.concureent.lock;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author: long
 * @create: 2022-05-05 20:42
 * @Description
 *
 * 实例分析是否为线程安全：主要看是否发生--逃逸
 *
 **/

public abstract class ThreadSafeAnalyse {

    public void bar(){
        SimpleDateFormat simpleFormatter = new SimpleDateFormat();
        foo(simpleFormatter);
    }
    //抽象方法
    public abstract void foo(SimpleDateFormat sf);

    public static void main(String[] args) {
        /**
         * 通过逃逸分析--父类bar()方法中的对象被子类用到了，因此局部变量也不是线程安全的
         */
        ThreadSafeAnalyse threadSafeAnalyse = new ChildThreadSafeAnalyse();
        threadSafeAnalyse.bar();
    }

}

class ChildThreadSafeAnalyse extends ThreadSafeAnalyse{


    @Override
    public void foo(SimpleDateFormat sf) {
        String date = "20220505";
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    sf.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
