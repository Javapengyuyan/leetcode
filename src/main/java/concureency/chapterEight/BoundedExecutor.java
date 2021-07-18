package Concureency.ChapterEight;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Semaphore {

    public void callerRuns(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (10,20,0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingDeque<>());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

    }

    


}