package com.designPatterns.structalModel.decoratorPattern;

/**
 * @author: long
 * @create: 2022-06-30 15:02
 * @Description
 **/

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape : circle");
    }
}
