package com.designPatterns.creativeModel.factory.abstractFactory;

/**
 * @author: long
 * @create: 2022-06-27 13:27
 * @Description
 **/

public class FruitFactory implements IFactory {
    @Override
    public Fruit createFruit(String type) {
        switch (type){
            case ("荔枝"):
                return new Litchi();
            case ("橘子"):
                return new Orange();
        }
        return null;
    }

    @Override
    public Meat createMeat(String type) {
        return null;
    }
}
