package basic.javaSE.reflect;

import basic.javaSE.chapter.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo2 {

    public static void main(String[] args) {
        Class personClass = Person.class;
        //1、Field[] getFields()获取所有public修饰成员变量
        Field[] fields = personClass.getFields();
        for (Object o: fields){
            System.out.println(o);
        }

        /**
         * 获取constructor方法
         */
        try {
            Constructor constructor = personClass.getConstructor();
            System.out.println("这是抽象方法："+constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        /**
         *
         */
        Method[] methods = personClass.getMethods();
        for (Method m : methods){
            System.out.println("这是person里面的方法"+m.getName());
        }

    }

}
