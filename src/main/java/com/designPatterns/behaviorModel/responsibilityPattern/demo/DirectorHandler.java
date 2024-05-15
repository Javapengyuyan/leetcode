package com.designPatterns.behaviorModel.responsibilityPattern.demo;

/**
 * @author: long
 * @create: 2023-01-04 16:14
 * @Description
 **/

public class DirectorHandler implements Handler {
    @Override
    public void handleRequest(String name, Integer days) {
        if (days < 7){
            System.out.println(name+"主管已经同意");
        }
    }
}
