package com.designPatterns.structalModel.decoratorPattern;

/**
 * @author: long
 * @create: 2022-06-30 15:01
 * @Description
 **/

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("shape : Rectangle");
    }
}
