package com.javaBasic.concureent.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author: long
 * @create: 2022-04-08 18:08
 * @Description
 *
 * 原子更新带有版本号的引用类型。该类将整数值与引用关联起来，
 * 可用于原子的更新数据和数据的版本号，可以解决使用CAS进行原子更新时可能出现的ABA问题。
 *
 **/

public class AtomicIntegerFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.
            newUpdater(User.class,"old");

    public static void main(String[] args) {
        User kenan = new User("kenan", 10);
        //柯南涨了一岁，任然输出旧年龄？
        System.out.println(a.getAndIncrement(kenan));
        //输出柯南年龄
        System.out.println(a.get(kenan));

    }

    public static class User {
        private String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
