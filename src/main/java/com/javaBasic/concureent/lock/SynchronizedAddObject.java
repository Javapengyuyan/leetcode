package com.javaBasic.concureent.lock;

/**
 * @author: long
 * @create: 2022-05-04 16:27
 * @Description 测试synchronized关键字给对象加锁，解决上下文切换问题
 *
 * 假如线程1用synchronized给对象加锁，线程2没有，则锁无效
 **/

//第一个class是面向过程加锁
public class SynchronizedAddObject {

    static int num = 0;
    static Object lock = new Object();

    public static void main(String[] args) {
        Room room = new Room();
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 5000; i++) {
                /*synchronized (lock){
                    num++;
                }*/
                room.increment();
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < 5000; i++) {
                /*synchronized (lock){
                    num--;
                }*/
                room.decrement();
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.sleep(100);
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("结果值："+num);
        System.out.println("结果值："+room.getCount());
    }

}

//使用面向对象思想将上个方法优化
class Room{
    private int count;
    public void increment(){
        //this表示：调用方法的那个对象
        synchronized (this){
            count++;
        }

    }

    public void decrement(){
        synchronized (this){
            count--;
        }
    }

    public int getCount(){
        synchronized (this){
            return count;
        }
    }

}
