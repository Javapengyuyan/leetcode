package com.designPatterns.responsibility;

public class GroupLeader implements Ratify{
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("Groupleader request:"+request.toString());
        if (request.getDay() > 1){
            Request newRequest = new Request();
            newRequest.setReason("项目也不忙");
            newRequest.setDay(request.getDay());
            return chain.proceed(newRequest);

        }
        return new Result(true,"早去早回");
    }
}
