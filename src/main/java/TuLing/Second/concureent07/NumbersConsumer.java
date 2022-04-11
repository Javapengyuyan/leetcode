package TuLing.Second.concureent07;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

/**
 * @author: long
 * @create: 2022-04-10 17:03
 * @Description 同步队列消费者
 **/

@Slf4j
public class NumbersConsumer implements Runnable{

    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true){
                Integer number = queue.take();//获取队列的头部元素并将其删除，如果队列为空，则阻塞并等待元
                if ( number.equals(poisonPill) ){
                    log.info("武大郎‐{}号,喝到毒药‐编号: {}挂了！！！",Thread.currentThread().getId(),number);
                    return;
                }
                log.info("武大郎‐{}号,喝药‐编号: {}",Thread.currentThread().getId(),number);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }
}
