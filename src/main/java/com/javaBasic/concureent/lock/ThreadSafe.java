package com.javaBasic.concureent.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: long
 * @create: 2022-05-05 16:16
 * @Description  判断是否为线程安全的
 *
 * 1、局部变量线程私有，属于线程安全
 * 2、成员变量需要考虑线程安全
 * 3、将成员变量改为局部变量试试
 *
 **/

public class ThreadSafe {

    /**
     * 1、局部变量 num
     */
    public void add(){
        int num = 0;
        num++;
    }

    public static void main(String[] args) {
        Unsafe unsafe = new Unsafe();
        //todo 必须要两个线程才能出现成员变量异常？
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                unsafe.method1();
            },"Thread"+i).start();
        }

        //此时线程为安全的
        Safe safe = new Safe();
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                //线程安全的原因是每个线程调用时候，都创建了一个新对象
                safe.method1();
            }).start();
        }

        //改为子类继承父类，然后重写method3，调用子类的method1
        childSafeMethod childSafeMethod = new childSafeMethod();
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                //线程不安全，原因是：子类和父类共享了资源
                //修改：将父类方法改为private修饰，防止子重写，
                // 不想被子类影响的公共方法用final修饰---final和private都不可被子类重写
                childSafeMethod.method1();
            }).start();
        }

    }

}

class Unsafe{
    /**
     * 2、成员变量 list
     */
    List list = new ArrayList();
    public void method2(){
        list.add("1");
    }
    public void method3(){
        list.remove(0);
    }
    public void method1(){
        for (int i = 0; i < 200; i++) {
            method2();
            method3();
        }
    }
}

class Safe{
    //局部变量
    public final void method1(){
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            method2(arrayList);
            method3(arrayList);
        }
    }
    private void method2(ArrayList<Object> arrayList){
        arrayList.add("1");
    }
    public void method3(ArrayList<Object> arrayList){
        arrayList.remove(0);
    }

}

class childSafeMethod extends Safe{

    @Override
    public void method3(ArrayList<Object> arrayList) {
        new Thread( ()->{
            arrayList.remove(0);
        } ).start();
    }
}


