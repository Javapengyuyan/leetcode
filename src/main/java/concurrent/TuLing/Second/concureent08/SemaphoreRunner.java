package concurrent.TuLing.Second.concureent08;

import java.util.concurrent.Semaphore;

/**
 * @author: long
 * @create: 2022-04-11 11:23
 * @Description
 **/

public class SemaphoreRunner {
    public static void main(String[] args) {
        /*int a = 8 % 16;
        System.out.println(a);
        int b = 16 % 8;
        System.out.println(b);*/

        //信号量：控制访问特定资源的线程数目，应用场景：服务限流(Hystrix里限流就有基于信号量方式)。
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new Thread(new Task(semaphore,"yanglong"+i)).start();
        }
    }

    static class Task extends Thread{
        Semaphore semaphore;
        public Task(Semaphore semaphore,String tname) {
            this.semaphore = semaphore;
            this.setName(tname);
        }

        @Override
        public void run() {
            try {
                //阻塞并获取许可
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"aquire() at time "
                        + System.currentTimeMillis());
                Thread.sleep(2000);
                //释放许可
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+"aquire() at time "
                        + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
