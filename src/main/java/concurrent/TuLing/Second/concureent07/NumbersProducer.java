package concurrent.TuLing.Second.concureent07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: long
 * @create: 2022-04-10 16:59
 * @Description 抽象队列同步器AQS应用--同步队列  生产者
 *
 **/
@Slf4j
public class NumbersProducer implements Runnable{

    private BlockingQueue<Integer> numbersQueue;
    private final int poisonPill;
    private final int poisonPillPerProducer;

    public NumbersProducer(BlockingQueue<Integer> numbersQueue, int poisonPill,
                           int poisonPillPerProducer) {
        this.numbersQueue = numbersQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void generateNumbers() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            numbersQueue.put(ThreadLocalRandom.current().nextInt(100));
            log.info("潘金莲‐{}号,给武大郎的泡药！",Thread.currentThread().getId());
        }
        for (int j = 0; j < poisonPillPerProducer; j++) {
            numbersQueue.put(poisonPill);
            log.info("潘金莲‐{}号,往武大郎的药里放入第{}颗毒丸！",Thread.currentThread().getId()
                    ,j+1);
        }

    }

}
