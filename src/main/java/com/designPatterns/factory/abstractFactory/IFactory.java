package com.designPatterns.factory.abstractFactory;

public interface IFactory {

    Fruit createFruit(String type);

    Meat createMeat(String type);

}
