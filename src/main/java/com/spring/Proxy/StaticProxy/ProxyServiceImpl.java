package com.spring.Proxy.StaticProxy;

public class ProxyServiceImpl implements UserService{

    UserServiceImpl service;

    @Override
    public String send(String name) {
        if (service == null){
            service = new UserServiceImpl();
        }
        System.out.println("虚假的送花人");
        return service.send(name);
    }

    @Override
    public void test() {

    }
}
