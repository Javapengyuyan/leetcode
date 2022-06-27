package com.designPatterns.factory.abstractFactory;

import sun.reflect.Reflection;

import java.lang.reflect.Method;

/**
 * @author: long
 * @create: 2022-06-27 12:03
 * @Description 工厂模式
 *
 * 1、抽象工厂负责创建各种工厂实例
 * 2、工厂实例创建对应的指定对象
 * 3、指定对象继承通用方法
 * 4、指定对象实现特定方法过程
 *
 *  弊端：需要客户端选择具体的工厂来创建
 **/

public class FactoryDemo {
    public static void main(String[] args) {
        /**
         * 通过反射实现
         */
        try {

            //Class<?> aClass = Class.forName("com.designPatterns.factory.abstractFactory.IFactory");
            Class<IFactory> aClass = (Class<IFactory>) Class.forName("com.designPatterns.factory.abstractFactory.IFactory");
            Method createFruitMethod = aClass.getMethod("createFruit", new Class[]{String.class});
            Object invoke = createFruitMethod.invoke(new FruitFactory(), new Object[]{"荔枝"});
            System.out.println(invoke);

            Method method = aClass.getMethod("com.designPatterns.factory.abstractFactory.IFactory.createFruit");

            FruitFactory fruitFactory = new FruitFactory();
            Fruit fruit = (Fruit) method.invoke(fruitFactory, "荔枝");
            fruit.cut();

            Method[] methods = aClass.getMethods();
            for (Method m: methods) {
                System.out.println(m);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 工厂模式调用
         */
        IFactory createFactory = new FruitFactory();
        Fruit fruit = createFactory.createFruit("橘子");
        fruit.cut();
        MeatFactory meatFactory = new MeatFactory();
        Meat meat = meatFactory.createMeat("鸡肉");
        meat.cookMeat();

    }
}
