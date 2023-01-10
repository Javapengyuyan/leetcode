package com.designPatterns.behaviorModel.strategyPattern;

/**
 * @author: long
 * @create: 2023-01-09 11:08
 * @Description
 **/

public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorythm() {
        System.out.println("物品累加打折出售");
    }
}
