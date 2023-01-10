package com.designPatterns.behaviorModel.strategyPattern;

/**
 * @author: long
 * @create: 2023-01-09 11:07
 * @Description
 **/

public class ConcreteStrategyA implements Strategy {
    @Override
    public void algorythm() {
        System.out.println("物品累加满减");
    }
}
