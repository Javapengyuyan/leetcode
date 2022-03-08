package com.javaBasic.javaSE.genericT.demo9;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: long
 * @create: 2021-12-28 14:54
 * @Description
 **/

public class Test9 {

    public static void main(String[] args) {
        /*ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        System.out.println(arrayList.getClass().getSimpleName());
        System.out.println(stringArrayList.getClass().getSimpleName());
        System.out.println( arrayList.getClass() == stringArrayList.getClass() );*/

        //无限制类型擦除，擦除类中的类型
        Erasure<Integer> erasure = new Erasure<>();
        Class<? extends Erasure> erasureClass = erasure.getClass();
        Field[] declaredFields = erasureClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + ":" + declaredField.getType().getSimpleName());
        }
        //有限制类型擦除，将Erasure改为extends Number
        for (Field declaredField : declaredFields) {
            //输出Number
            System.out.println(declaredField.getName() + ":" + declaredField.getType().getSimpleName());
        }

        System.out.println("------------------------------------------");

        //擦除方法中类型定义的参数
        Method[] declaredMethods = erasureClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName()+"方法参数"+method.getReturnType().getSimpleName() );
        }

        System.out.println("------------------------------------------");
        //桥接方法
        //保持接口和类的实现关系的。原有方法保持不变，并新加一个擦除后的Oject方法
        Class<InfoImpl> infoClass = InfoImpl.class;
        Method[] infoImplMethods = infoClass.getDeclaredMethods();
        for (Method infoImplMethod : infoImplMethods) {
            System.out.println( infoImplMethod.getName()+":"+infoImplMethod.getReturnType().getSimpleName() );
        }


    }

}
