package concurrent.TuLing.Second.concureent08;

import java.util.concurrent.CyclicBarrier;

/**
 * @author: long
 * @create: 2022-04-11 14:49
 * @Description 栅栏屏障
 **/

public class CyclicBarrierRunner {

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("所有特工到达屏障，准备开始执行任务");
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread((new CyclicBarrierTest(cyclicBarrier, i))).start();
        }
        cyclicBarrier.await();
        System.out.println("全部到达屏障，进入敌军作战");
    }

}

class CyclicBarrierTest implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private int index;

    public CyclicBarrierTest(CyclicBarrier cyclicBarrier, int index) {
        this.cyclicBarrier = cyclicBarrier;
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("index:"+index);
        index--;
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

