package com.designPatterns.creativeModel.factory.abstractFactory;

/**
 * @author: long
 * @create: 2022-06-27 13:59
 * @Description
 **/

public class Chicken extends Meat {

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public void setHit(Double hit) {
        super.setHit(hit);
    }

    @Override
    public void cookMeat() {
        System.out.println("炸鸡肉");
    }
}
