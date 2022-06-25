package com.javaBasic.concureent.homeWork;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author: long
 * @create: 2022-05-06 10:36
 * @Description 模拟多人买票场景
 **/
@Slf4j
public class ExerciseSell {

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        List<Integer> countList = new Vector<>();
        TicketWindow ticketWindow = new TicketWindow(2000);
        for (int i = 0; i < 400; i++) {
            Thread thread = new Thread(() -> {
                int sell = ticketWindow.sell(random(5));
                countList.add(sell);
            });
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("余票数："+ticketWindow.getCount());
        log.info("统计卖出去的票数："+ countList.stream().mapToInt
                ( o-> Objects.isNull(o)?0:o ).sum() );


    }
    //随机1-5票数
    static Random random = new Random(50);
    public static int random(int amount){
        int nextInt = random.nextInt(amount)+1;
        return nextInt;
    }


}
//卖票窗口
class TicketWindow {
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }
    //余票数量
    public int getCount(){
        return count;
    }

    //加入synchronized保证这块线程安全
    public synchronized int sell(int amount){
        if (count>=amount){
            this.count -= amount;
            return amount;
        }else {
            return 0;
        }
    }

}