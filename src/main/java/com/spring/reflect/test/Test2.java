package com.spring.reflect.test;

import java.lang.reflect.Method;

public class Test2 {

    public static void main(String[] args) throws Exception {
        Class dogClass = Dog.class;
        Method eat = dogClass.getMethod("eat");
        Object dog = dogClass.newInstance();
        eat.invoke(dog);
        Method method = dogClass.getMethod("eat",String.class);
        method.invoke(dog,"meat");
        Method[] fields = dogClass.getDeclaredMethods();
        for (Method field : fields) {
            System.out.println(field.getName());
        }



    }

}
