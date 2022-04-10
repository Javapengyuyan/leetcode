package com.javaBasic.concureent.thread.demo01;

/**
 * @author: long
 * @create: 2022-02-11 10:30
 * @Description
 **/

public class Race implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("兔子")){
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            boolean gameOver = gameOver(i);
            if (gameOver){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }

    }

    private boolean gameOver(int step){
        if (winner != null){
            return true;
        }else if (step >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is"+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();

    }

}
