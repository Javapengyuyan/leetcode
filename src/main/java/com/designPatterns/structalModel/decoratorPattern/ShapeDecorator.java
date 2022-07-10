package com.designPatterns.structalModel.decoratorPattern;

/**
 * @author: long
 * @create: 2022-06-30 15:03
 * @Description 抽象装饰类
 **/

public abstract class ShapeDecorator implements Shape{

    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    /**
     * 抽象类实现接口不需要强制重写接口内方法。
     */
    @Override
    public void draw() {
        decoratorShape.draw();
    }
}
