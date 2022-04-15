package com.javaBasic.concureent.lock;

/**
 * @author: long
 * @create: 2022-04-13 14:38
 * @Description
 **/

public class LockTest {

    static Integer total = 0;
    public static void main(String[] args) {
        //乐观锁、悲观锁
        //锁定代码块
        synchronized (LockTest.class){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (total < 100){
                        total++;
                    }
                }
            });

        }

        //重入锁、非重入

        //轻量级、重量锁

        //公平锁、非公平


    }

}
