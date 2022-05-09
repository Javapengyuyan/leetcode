package com.javaBasic.concureent.lock.reentrantLockDemo;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: long
 * @create: 2022-05-08 16:32
 * @Description reentrantLock解决哲学家就餐问题
 **/

public class ReentrantLockDemo3_dinner {

    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");
        new Philosopher("苏格拉底",c1,c2).start();
        new Philosopher("泊拉图",c2,c3).start();
        new Philosopher("亚里士多德",c3,c4).start();
        new Philosopher("赫拉克里特",c4,c5).start();
        new Philosopher("阿基米德",c5,c1).start();


    }



}

@Slf4j(topic = "Philosopher")
class Philosopher extends Thread{
    Chopstick left;
    Chopstick right;

    public Philosopher(String name,Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {

        while (true){
            /*
            //获取左手筷子
            synchronized (left){//会造成死锁，换方法
                //获取右手筷子
                synchronized (right){
                    eat();
                }
            }*/
            if ( left.tryLock() ){
                try {
                    if ( right.tryLock() ){
                        /**
                         * 一定要在finally里写释放锁
                         */
                        try {
                            eat();

                        }finally {
                            right.unlock();
                        }
                    }
                }finally {
                    left.unlock();
                }
            }

        }
    }

    Random random = new Random();
    private void eat() {
        //Sleeper.sleep(0.5);
        log.debug("eating....");
        int nextInt = random.nextInt(1000);
        try {
            Thread.sleep(nextInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class Chopstick extends ReentrantLock {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chopstick(String name) {
        this.name = name;
    }
}
