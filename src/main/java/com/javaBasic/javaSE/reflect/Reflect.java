package com.javaBasic.javaSE.reflect;

import com.javaBasic.javaSE.Father;

public class Reflect {

    /**
     * source源代码阶段 java文件编译成class文件，还存放在硬盘上 没有进入内存
     *
     * class类对象阶段： 通过类加载器，将字节码文件加载到内存中，Class类对象
     *
     * 运行时阶段：new 对象
     *
     */

    /**
     *  获取Class对象的三种方法：
     *
     *  1、将字节码文件加载进内存
     *   多用于配置文件中，将类名定义在配置文件中
     *
     *  2、通过类名的属性class来获取
     *   多用于参数传递
     *
     *  3、通过 对象.getClass方法来获取
     *   多用于对象的获取字节码方式
     *
     */
    public static void main(String[] args) {
        try {
            //1、
            Class f1 = Class.forName("com.javaBasic.javaSE.Father");
            System.out.println(f1);
            //2、
            Class f2 = Father.class;
            System.out.println(f2);

            Father father = new Father();
            //3
            Class f3 = father.getClass();
            System.out.println(f3);
            System.out.println(f1 == f2);
            System.out.println(f1 == f3);
            /**
             * 结论：
             *  同一字节码文件(*.class)在一次程序运行过程中，只会被加载一次，
             *  不论通过哪一种方式获取的class对象都是同一个。
             *
             */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
    public void classTest(){
        try {

            Class.forName("Construction");
            Class.forName(String.valueOf(Father.class));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2、通过类名的属性class来获取
        Class<Father> father = Father.class;
        //3、通过 对象.getClass方法来获取
        Father father1 = new Father();
        father1.getClass();

    }


}
