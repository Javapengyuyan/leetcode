package com.designPatterns.behaviorModel.responsibilityPattern;

public interface Ratify {

    //处理请求
    Result deal(Chain chain);

    /**
     * 接口描述:对request和Result封装，用来转发
     */
    interface Chain{
        Request request();

        Result proceed(Request request);
    }

}
