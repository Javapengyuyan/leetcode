package basic.thread;

/**
 * @author: long
 * @create: 2022-02-10 23:08
 * @Description
 *
 * 多线程操作同一资源时候，线程不安全，数据紊乱
 **/

public class TestThread04 implements Runnable{

    private int tickeNums = 10;

    @Override
    public void run() {
        while (true){
            if (tickeNums<=0){
                return;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+tickeNums--+"张票");
        }

    }

    public static void main(String[] args) {
        TestThread04 tickts = new TestThread04();
        new Thread(tickts,"小明").start();
        new Thread(tickts,"小红").start();
        new Thread(tickts,"黄牛党").start();

    }
}
