package com.spring.reflect.test;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) throws Exception {
        //获取对象法一
        Class dogClass = Dog.class;
        //获取对象法二
        Class dogClass2 = Class.forName("com.spring.reflect.test.Dog");
        //获取对象法三
        Dog dog = new Dog("");
        /*Class dogClass3 = dog.getClass();
        System.out.println(dogClass.getSuperclass().getName());
        //System.out.println(dogClass2.getResource("src.main.resources.application.properties").getPath());
        System.out.println(dogClass3.isInterface());
        dog.eat("chishi");*/

        //拿到共有的字段
        Field[] fields = dogClass.getFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }
        //拿到所有的字段
        Field[] fields1 = dogClass.getDeclaredFields();
        for (Field field : fields1){
            System.out.println(field.getName());
        }
        try {
            System.out.println(dogClass.getField("color"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //获取对象属性
        Field name = dogClass.getDeclaredField("name");
        name.set(dog,"xiaohei");
        System.out.println(dog.getName());

        //暴力注入---给私有属性赋值
        Object dogObject = new Dog("");//父类引用指向子类对象----多态
        Field color = dogClass.getDeclaredField("color");
        color.setAccessible(true);
        color.set(dog,"black");
        System.out.println(color.getName());

    }

}
