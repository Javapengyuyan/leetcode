package concurrent.TuLing.Second.concureent07;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: long
 * @create: 2022-04-10 17:36
 * @Description
 **/

public class Test {
    public static void main(String[] args) {
        int BOUND = 10;
        int N_PRODUCERS = 16;
        int poisonPill = Integer.MAX_VALUE;
        //todo 可用的计算资源
        //int N_CONSUMERS = Runtime.getRuntime().availableProcessors();//8
        int N_CONSUMERS = 8;
        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;//0
        int mod = N_CONSUMERS % N_PRODUCERS;//求余数

        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(BOUND);
        //潘金莲给武大郎熬药
        for (int i = 0; i < N_PRODUCERS; i++) {
            new Thread(new NumbersProducer(blockingQueue,poisonPill,
                    poisonPillPerProducer)).start();
        }

        //武大郎开始喝药
        for (int i = 0; i < N_CONSUMERS; i++) {
            new Thread(new NumbersConsumer(blockingQueue,poisonPill)).start();
        }

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //潘金莲开始投毒，武大郎喝完毒药GG
        new Thread(new NumbersProducer(blockingQueue,poisonPill,
                poisonPillPerProducer+mod)).start();

        //todo 疑惑  为什么消费者都挂了，（）没有退出，因为指令重排问题？


    }
}
