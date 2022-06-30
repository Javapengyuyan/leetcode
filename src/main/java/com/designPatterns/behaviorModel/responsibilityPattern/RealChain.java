package com.designPatterns.behaviorModel.responsibilityPattern;

import java.util.List;

public class RealChain implements Ratify.Chain {

    public Request request;
    public List<Ratify> ratifyList;
    public int index;

    public RealChain(List<Ratify> ratifyList,Request request,int index){
        this.ratifyList = ratifyList;
        this.request = request;
        this.index = index;
    }

    /**
     * 方法描述：具体转发功能
     * @return
     */
    @Override
    public Result proceed(Request request) {
        Result proceed = null;
        if (ratifyList.size() > index ){
            RealChain realChain = new RealChain(ratifyList,request,index+1);
            Ratify ratify = ratifyList.get(index);
            proceed = ratify.deal(realChain);
        }
        return proceed;
    }


    @Override
    public Request request() {
        return request;
    }


}
