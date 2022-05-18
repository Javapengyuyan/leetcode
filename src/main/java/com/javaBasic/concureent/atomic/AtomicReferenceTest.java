package com.javaBasic.concureent.atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: long
 * @create: 2022-04-08 17:52
 * @Description 原子操作引用类型
 **/

public class AtomicReferenceTest {
    public static AtomicReference<User> atomicReference = new AtomicReference<>();
    public static void main(String[] args) {
        User user = new User("conan", 15);
        atomicReference.set(user);
        User updataUser = new User("shanjing", 18);
        atomicReference.compareAndSet(user,updataUser);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getOld());


    }

    static class User{
        private String name;
        private int old;
        public User(String name,int old){
            this.name = name;
            this.old = old;
        }
        public String getName(){
            return name;
        }
        public int getOld(){
            return old;
        }
    }
}
