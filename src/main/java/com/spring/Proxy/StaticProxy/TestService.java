package com.spring.Proxy.StaticProxy;

public class TestService {

    public static void main(String[] args) {

        ProxyServiceImpl proxyService = new ProxyServiceImpl();
        proxyService.send("flower");


    }

}
