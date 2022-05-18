package com.javaBasic.concureent.atomic;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: long
 * @create: 2022-05-16 11:06
 * @Description
 * 1、原子基本类型
 * AtomicInteger基本api使用
 * 2、原子引用类型
 *
 **/

public class AtomicDemo02 {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        int i = integer.incrementAndGet();
        System.out.println(i);
        int andIncrement = integer.getAndIncrement();
        System.out.println(andIncrement);
        System.out.println(integer.get());
        int updateAndGet = integer.updateAndGet(value -> value * 10);


        AtomicReference<BigDecimal> decimalAtomicReference = new AtomicReference<>();
        //decimalAtomicReference.compareAndSet()

    }
}

class DecimalAccountCas {
    private AtomicReference<BigDecimal> balance;

    public DecimalAccountCas(BigDecimal balance) {
        this.balance = new AtomicReference<>(balance);
    }

    public BigDecimal getBalance(){
        return balance.get();
    }

    public void withdraw(BigDecimal amout){
        while (true){
            BigDecimal pre = balance.get();
            BigDecimal next = pre.subtract(amout);
            if (balance.compareAndSet(pre,next)){
                break;
            }
        }
    }

}
