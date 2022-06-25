package com.javaBasic.concureent.concureencyPratice.chapterEight;

import java.util.concurrent.*;

public class BoundedExecutor {

    public void callerRuns(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (10,20,0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingDeque<>());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

    }

    //8-4
    private final Executor exec;
    private final Semaphore semaphore;
    public BoundedExecutor(Executor exec,int bound){
        this.exec = exec;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    command.run();
                }finally {
                    semaphore.release();
                }

            }
        });

    }






}