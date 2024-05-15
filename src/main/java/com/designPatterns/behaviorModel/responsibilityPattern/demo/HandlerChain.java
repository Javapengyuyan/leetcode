package com.designPatterns.behaviorModel.responsibilityPattern.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: long
 * @create: 2023-01-04 16:16
 * @Description  用户
 **/

public class HandlerChain implements Handler {

    private List<Handler> handlerList;

    public HandlerChain() {
        this.handlerList = new ArrayList<>();
    }

    public HandlerChain addHandler(Handler handler){
        handlerList.add(handler);
        return this;
    }

    @Override
    public void handleRequest(String name, Integer days) {
        for (Handler handler : handlerList){
            handler.handleRequest(name,days);
        }
    }
}
