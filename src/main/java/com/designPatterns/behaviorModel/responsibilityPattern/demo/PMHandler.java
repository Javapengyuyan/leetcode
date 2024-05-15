package com.designPatterns.behaviorModel.responsibilityPattern.demo;

/**
 * @author: long
 * @create: 2023-01-04 16:14
 * @Description
 **/

public class PMHandler implements Handler {
    @Override
    public void handleRequest(String name, Integer days) {
        if (days <3 ){
            System.out.println(name+"组长已经同意");
        }
    }
}
