package com.designPatterns.structalModel.decoratorPattern;

/**
 * @author: long
 * @create: 2022-06-30 15:09
 * @Description 装饰器模式
 **/

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("circle with normal border");
        circle.draw();

        System.out.println("\ncircle of red border");
        redCircle.draw();

        System.out.println("\nrectangle of red border");
        redRectangle.draw();

    }
}
