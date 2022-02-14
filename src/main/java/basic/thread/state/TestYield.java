package basic.thread.state;

/**
 * @author: long
 * @create: 2022-02-13 20:05
 * @Description
 * 让当前执行的线程暂停，但不阻塞，
 * 将线程从运行状态变为就绪状态。
 * 线程礼让，礼让不一定成功。看CPU心情
 **/

public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }

}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println("线程开始执行"+Thread.currentThread().getName());
        Thread.yield();
        System.out.println("线程执行结束"+Thread.currentThread().getName());
    }
}
