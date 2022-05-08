package com.javaBasic.concureent.thread.state;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: long
 * @create: 2022-05-07 16:18
 * @Description 两阶段终止模式--模拟一个线程监控另一个线程
 **/

public class InterruptedDemo02 {

    /**
     * 调用stop方法强行会导致锁没有释放，造成死锁。因此可以使用Interrupted终止线程
     *
     */
    public static void main(String[] args) {
        TwoPhaseTermination termination = new TwoPhaseTermination();
        termination.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        termination.stop();

        Thread thread = new Thread();
        thread.interrupt();
        thread.isInterrupted();
        Thread.interrupted();//区别：这个会清除打断标记


    }

}

@Slf4j(topic = "TwoPhaseTermination")
class TwoPhaseTermination{

    private Thread monitor;

    //启动监控线程
    public void start(){
        monitor = new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                boolean interrupted = currentThread.isInterrupted();
                if (interrupted) {
                    log.info("做后事处理");
                    break;
                }
                log.info("运行中");
                try {
                    currentThread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    /**
                     * 重点：
                     * 注意这里，这里是打断出现异常需要再改变状态的地方
                     */
                    currentThread.interrupt();
                }

            }
        });
        monitor.start();
    }

    public void stop(){
        monitor.interrupt();
    }


}
