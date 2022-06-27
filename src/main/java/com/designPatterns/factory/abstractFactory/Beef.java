package com.designPatterns.factory.abstractFactory;

/**
 * @author: long
 * @create: 2022-06-27 14:03
 * @Description
 **/

public class Beef extends Meat {

    @Override
    public void setHit(Double hit) {
        super.setHit(hit);
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public void cookMeat() {
        System.out.println("卤牛肉");
    }
}
