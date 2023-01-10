package com.designPatterns.behaviorModel.strategyPattern;

/**
 * @author: long
 * @create: 2022-06-23 16:38
 * @Description 策略模式
 **/

public class StrategyTest {

    public static void main(String[] args) {
        //交给客户端选择
        ConcreteStrategyA concreteStrategyA = new ConcreteStrategyA();
        Context context = new Context(concreteStrategyA);
        context.contextInter();

    }

}
