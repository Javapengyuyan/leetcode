package com.spring.Proxy.StaticProxy;

/**
 * @author: long
 * @create: 2022-02-20 13:00
 * @Description
 **/

public class MyProxyTest {
    public static void main(String[] args) {
        ProxyOrg proxyOrg = new ProxyOrg();
        proxyOrg.weeding("张三");

    }
}

interface Proxy{
    void weeding(String name);
}

class WeedUser implements Proxy{

    @Override
    public void weeding(String name) {
        System.out.println(name+"结婚了！");
    }
}

class ProxyOrg implements Proxy{

    WeedUser weedUser = new WeedUser();

    @Override
    public void weeding(String name) {
        System.out.println("婚庆公司婚前布置");
        weedUser.weeding(name);
        System.out.println("婚后收钱");
    }
}


