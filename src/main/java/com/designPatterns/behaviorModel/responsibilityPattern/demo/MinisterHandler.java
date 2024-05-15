package com.designPatterns.behaviorModel.responsibilityPattern.demo;

/**
 * @author: long
 * @create: 2023-01-04 16:15
 * @Description
 **/

public class MinisterHandler implements Handler {
    @Override
    public void handleRequest(String name, Integer days) {
        if (days < 20){
            System.out.println(name+"总监已经同意");
        }
    }
}
