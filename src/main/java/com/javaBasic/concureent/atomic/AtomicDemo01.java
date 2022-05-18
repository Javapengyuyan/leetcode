package com.javaBasic.concureent.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: long
 * @create: 2022-05-15 22:04
 * @Description 第六章--无锁并发，CAS原理，atomic原子类
 **/

public class AtomicDemo01 {
    public static void main(String[] args) {
        AccountCas account = new AccountCas(10000);
        AccountCas.demo(account);
    }

}

class AccountCas {
    private AtomicInteger balance;

    public AccountCas(int balance) {
        this.balance = new AtomicInteger(balance);
    }


    //获取余额
    public Integer getBalance() {
        return balance.get();
    }

    //取款
    public void withDraw(Integer amount){
        /*while (true){
            int pre = balance.get();
            int next = pre-amount;
            if (balance.compareAndSet(pre,next)){
                break;
            }
        }*/
        balance.getAndAdd(-1*amount);
    }

    static void demo(AccountCas account){
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Thread(()->{
                account.withDraw(10);
            }));
        }
        long start = System.nanoTime();
        list.forEach(Thread::start);
        list.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        /**
         * 1000_000--java7特性，增强数字可读性
         */
        System.out.println(account.getBalance()+"cost:"+(end-start)/1000_000+"ms");

    }

}
