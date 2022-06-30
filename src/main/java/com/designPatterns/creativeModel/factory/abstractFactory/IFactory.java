package com.designPatterns.creativeModel.factory.abstractFactory;

public interface IFactory {

    Fruit createFruit(String type);

    Meat createMeat(String type);

}
