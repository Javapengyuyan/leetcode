package com.designPatterns.creativeModel.factory.abstractFactory;

/**
 * @author: long
 * @create: 2022-06-27 14:11
 * @Description
 **/

public class MeatFactory implements IFactory{

    @Override
    public Fruit createFruit(String type) {
        return null;
    }

    @Override
    public Meat createMeat(String type) {
        switch (type){
            case "鸡肉":
                return new Chicken();
            case "牛肉":
                return new Beef();
        }
        return null;
    }

}
