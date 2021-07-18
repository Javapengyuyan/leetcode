package concureency.chapterEight;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class TimingThreadPool extends ThreadPoolExecutor {

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    private final ThreadLocal<Long> starttime = new ThreadLocal<>();
    private final Logger log = Logger.getLogger("TimingThreadpool");
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    protected void beforeExecute(Thread t,Runnable r){
        super.beforeExecute(t,r);
        log.fine(String.format("Thread %s: start: %s",t,r));
        starttime.set(System.nanoTime());
    }


    protected void terminated(){
        try {
            log.info(String.format(""));
        }finally {
            super.terminated();
        }
    }

}
