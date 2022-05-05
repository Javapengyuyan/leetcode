package com.javaBasic.concureent.lock;

/**
 * @author: long
 * @create: 2022-05-05 12:59
 * @Description  synchronized只能锁对象，加在方法上锁的是this对象，加在static方法上锁的是类对象
 *
 **/

public class SynchronizedAddMethod {
    /**
     * 加在成员方法上
     *
     * test01() 和 test1() 两者等价
     */
    public synchronized void test01(){

    }
    public void test1(){
        synchronized (this){

        }
    }

    /**
     * 加在static方法上
     *
     * test02()和test2()等价
     */
    public static synchronized void test02(){

    }
    public static void test2(){
        synchronized (SynchronizedAddMethod.class){

        }
    }


}
