package basic.io.bio.four;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: long
 * @create: 2022-01-03 15:06
 * @Description
 **/

public class HandlerSocketServerPool {
    //1、创建一个线程池成员变量，用来存储线程池对象
    public ExecutorService executorService;

    /**
     * 2、初始化线程池对象
     * int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler
     *
     * LinkedBlockingDeque:基于链表的无界阻塞队列
     *
     *
     */
    public HandlerSocketServerPool(int coreSize,int queneSize){
        /**
         * 线程工厂
         *
         */
        //ThreadFactory threadFactory = Thread::new;
        //ThreadFactory threadFactory2 = Executors.defaultThreadFactory();
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        /**
         * 拒绝策略
         */
        ThreadPoolExecutor.CallerRunsPolicy runsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        //ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        //ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        //ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();

        executorService = new ThreadPoolExecutor(coreSize,10,
                120, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queneSize),
                threadPoolTaskExecutor,runsPolicy);


    }

    public void executor(Runnable runnable){
        executorService.execute(runnable);
    }




}
