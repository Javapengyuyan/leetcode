package com.javaBasic.concureent.homeWork;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: long
 * @create: 2022-04-19 11:20
 * @Description
 **/

public class ThreadLocalTest {

    public static void main(String[] args) {
        //method1();
        method2();

    }

    /**
     * 这种情况下打印结果出现大量重复值，说明SimpleDateFormat线程安全问题
     */
    static public void method1(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        for (int i = 0; i < 10; i++) {
            int finall = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(finall*1000);
                    String format = dateFormat.format(date);
                    System.out.println(format);
                }
            }).start();
        }
    }

    static public void method2(){

        for (int i = 0; i < 10; i++) {
            int finall = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(finall*1000);
                    ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.
                            withInitial(() -> new SimpleDateFormat("mm:ss"));
                    try {
                        SimpleDateFormat dateFormat = dateFormatThreadLocal.get();
                        String format = dateFormat.format(date);
                        System.out.println(format);
                    }finally {
                        /**
                         * 防止内存溢出
                         */
                        dateFormatThreadLocal.remove();
                    }
                }
            }).start();
        }
    }

}
