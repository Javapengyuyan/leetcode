package com.javaBasic.javaSE.chapter;


import com.javaBasic.javaSE.Father;

/**
 *  核心卷一：5.1.10
 */
public class Child extends Father {

    public static void main(String[] args) {

        String fo = "zhanweifu%9d";
        String format = String.format(fo, 2);
        System.out.println("占位符的使用："+format);

        Father father = new Father();
        /**
         * 超类中的protected方法不允许被子类直接访问,因此run()方法会报错
         */
        //father.run();
        father.jump();
        /**
         * 新创建子类可以调用超类的protected方法。
         */
        Child child = new Child();
        child.run();

    }

}
