package concurrent.TuLing.Second.concureent08;

import java.util.concurrent.CountDownLatch;

/**
 * @author: long
 * @create: 2022-04-11 14:24
 * @Description CountDownLaunch
 **/

public class CountDownLaunchRunner {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new QueueTask(countDownLatch)).start();
        new Thread(new SeeDoctorTask(countDownLatch)).start();
        countDownLatch.await();
        System.out.println("回家，总共耗时："+ (System.currentTimeMillis()-start ));
    }

}

class QueueTask implements Runnable{

    private CountDownLatch countDownLatch;

    public QueueTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            System.out.println("开始排队买药");
            Thread.sleep(5000);
            System.out.println("拍完，买完药了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (countDownLatch != null){
                countDownLatch.countDown();
            }
        }

    }
}

class SeeDoctorTask implements Runnable{
    private CountDownLatch countDownLatch;

    public SeeDoctorTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("媳妇去看病");
            Thread.sleep(2000);
            System.out.println("媳妇看完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (countDownLatch != null){
                countDownLatch.countDown();
            }
        }
    }
}
