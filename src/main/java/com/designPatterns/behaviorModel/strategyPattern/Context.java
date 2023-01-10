package com.designPatterns.behaviorModel.strategyPattern;

/**
 * @author: long
 * @create: 2023-01-09 11:13
 * @Description
 **/

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInter(){
        strategy.algorythm();
    }

}
