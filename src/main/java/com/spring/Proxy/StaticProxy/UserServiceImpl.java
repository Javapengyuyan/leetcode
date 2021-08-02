package com.spring.Proxy.StaticProxy;

public class UserServiceImpl implements UserService{
    @Override
    public String send(String name) {
        System.out.println("真实得送花人");
        return name;
    }
}
