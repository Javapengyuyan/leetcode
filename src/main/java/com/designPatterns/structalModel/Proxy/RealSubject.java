package com.designPatterns.structalModel.Proxy;

public class RealSubject implements Subject{

    @Override
    public void Request(String name) {
        System.out.println("真实的请求"+name);
    }
}
