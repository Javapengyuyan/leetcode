package com.spring.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test3 {

    //通过类构造方法创建一个dog实例对象，给对象赋值
    public static void main(String[] args) throws Exception {
        Class dogClass = Dog.class;
        //构造函数
        Constructor constructor = dogClass.getConstructor(String.class);
        Object dog = constructor.newInstance("blue");
        Field color = dogClass.getDeclaredField("color");
        color.setAccessible(true);
        color.set(dog,"blue");

        System.out.println(color.get(dog));

    }

}
