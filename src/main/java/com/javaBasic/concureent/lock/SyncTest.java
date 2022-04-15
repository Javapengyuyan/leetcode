package com.javaBasic.concureent.lock;

import java.math.BigDecimal;

/**
 * @author: long
 * @create: 2022-04-13 17:11
 * @Description
 *
 * synchronized可以修饰：1、普通方法。2、静态方法。3、代码块。4、类。
 *
 **/

public class SyncTest {
    public static void main(String[] args) {

    }

    /**
     * 1、实例方法
     * @param a
     */
    public synchronized void addNum(int a){
        if (a<100){
            a++;
        }
    }

    /**
     * 2、静态方法
     */
    public static synchronized void addNum(){

    }

    /**
     * 3、修饰代码块---减小锁粒度
     * @param name
     * @param money
     *
     *  3.1、锁对象是变量
     *
     */
    public void lock(String name, BigDecimal money){
        BigDecimal bigDecimal = new BigDecimal(0);
        synchronized (money){
            money.add(bigDecimal);
        }


    }

    /**
     * 3.2、锁对象是实例对象this
     *
     */
    public void addSync(){
        synchronized (this){

        }
    }

    /**
     * 修饰类
     * 3.3、锁对象是当前类class对象锁
     *
     */
    public void addAll(){
        synchronized (SyncTest.class){
            System.out.println("锁住类");
        }
    }

}
