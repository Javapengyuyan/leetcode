package com.designPatterns.behaviorModel.responsibilityPattern;

public class DepatmentManager implements Ratify{
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        if (request.getDay() > 7){
            return new Result(false,"你这个没必要");
        }
        return new Result(true,"早去早回");
    }
}
