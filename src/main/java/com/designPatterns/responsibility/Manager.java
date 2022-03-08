package com.designPatterns.responsibility;

public class Manager implements Ratify{
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        if (request.getDay() > 5 ){
            Request newRequest = new Request();
            newRequest.setReason("每月的KPI考核还不错，可以批准");
            newRequest.setDay(request.getDay());
            return chain.proceed(newRequest);
        }
        return new Result(true,"早点办完");
    }
}
