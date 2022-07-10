package com.designPatterns.structalModel.decoratorPattern;

/**
 * @author: long
 * @create: 2022-06-30 15:06
 * @Description ShapeDecorator实体装饰类
 **/

public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void draw() {
        decoratorShape.draw();
        setRedBorder(decoratorShape);
    }

    private void setRedBorder(Shape decoratorShape){
        System.out.println("border color : red");
    }
}
