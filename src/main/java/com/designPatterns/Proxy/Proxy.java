package com.designPatterns.Proxy;

public class Proxy implements Subject{

    RealSubject realSubject;

    @Override
    public void Request(String name) {
        System.out.println("代理的请求"+name);
        if (realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.Request(name);

    }
}
