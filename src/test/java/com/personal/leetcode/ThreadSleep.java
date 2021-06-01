package com.personal.leetcode;

public class ThreadSleep extends Thread{

    public void run(){
        for (int i=0;i<10;i++){
            System.out.println("线程输出");
            try {
                sleep(1000);
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new ThreadSleep();
        thread.start();




    }

}
