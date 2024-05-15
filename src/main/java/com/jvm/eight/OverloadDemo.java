package com.jvm.eight;

/**
 * @author: long
 * @create: 2022-12-23 18:00
 * @Description
 **/

public class OverloadDemo {

    static abstract class Human{}

    static class Man extends Human{}

    static class Woman extends Human{}

    public void od(Human human){
        System.out.println("human");
    }

    public void od(Man man){
        System.out.println("man");
    }

    public void od(Woman woman){
        System.out.println("woman");
    }

    public static void main(String[] args) {
        Man man = new Man();
        Human man2 = new Man();
        Woman woman = new Woman();
        Human woman2 = new Woman();
        OverloadDemo overloadDemo = new OverloadDemo();
        overloadDemo.od(man);
        overloadDemo.od(man2);
        overloadDemo.od(woman);
        overloadDemo.od(woman2);

    }

}
