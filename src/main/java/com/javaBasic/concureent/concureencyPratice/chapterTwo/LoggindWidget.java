package com.javaBasic.concureent.concureencyPratice.chapterTwo;

/**
 *  如果内置锁不可重入锁，则会导致代码永久死锁。
 *
 *
 */

public class LoggindWidget extends Widget{
    public synchronized void doSomeing(){
        System.out.println(toString()+":calling doSomething");
        super.doSomeing();
    }


}
