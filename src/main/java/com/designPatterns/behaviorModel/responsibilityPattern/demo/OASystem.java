package com.designPatterns.behaviorModel.responsibilityPattern.demo;

/**
 * @author: long
 * @create: 2023-01-04 16:20
 * @Description 这种模式方便修改、交换处理人顺序
 **/

public class OASystem {

    public static void main(String[] args) {
        PMHandler pmHandler = new PMHandler();
        DirectorHandler directorHandler = new DirectorHandler();
        MinisterHandler ministerHandler = new MinisterHandler();
        HandlerChain handlerChain = new HandlerChain()
                .addHandler(pmHandler)
                .addHandler(directorHandler)
                .addHandler(ministerHandler);
        handlerChain.handleRequest("李二",6);


    }

}
