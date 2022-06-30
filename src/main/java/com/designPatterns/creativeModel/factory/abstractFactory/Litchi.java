package com.designPatterns.creativeModel.factory.abstractFactory;

/**
 * @author: long
 * @create: 2022-06-27 13:26
 * @Description
 **/

public class Litchi extends Fruit {

    @Override
    public void setSize(Integer size) {
        super.setSize(size);
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public void cut() {
        System.out.println("给荔枝剥皮");
    }
}
