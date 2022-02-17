package basic.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: long
 * @create: 2022-02-15 14:33
 * @Description
 *
 * 1、Lock是显示锁，synchronized是隐式锁，出了作用域自动释放
 * 2、Lock只能锁代码块，synchronized有代码块和方法
 * 3、使用Lock锁，JVM花费较少时间来调度线程
 * 4、先后顺序：Lock>同步代码块>同步方法
 *
 **/

public class TestLock {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();

    }
}

class BuyTicket implements Runnable{

    private int ticket = 10;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {

        while (true){
            try {
                reentrantLock.lock();//加锁位置要注意
                if (ticket >0){
                    try {

                        //reentrantLock.lock();//在这里加锁可能会导致当前线程不含有资源，锁释放失败
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticket--);
                }else {
                    break;
                }
            }finally {
                reentrantLock.unlock();
            }


        }

    }
}
