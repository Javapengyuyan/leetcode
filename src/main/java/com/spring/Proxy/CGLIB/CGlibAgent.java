package com.spring.Proxy.CGLIB;

import com.spring.Proxy.JDK.Apple;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibAgent implements MethodInterceptor{

    //被代理的对象
    private Object proxy;

    public Object getInstance(Object proxy){
        this.proxy = proxy;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.proxy.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(">>>>>>befor invoking");
        //真正调用
        Object ret = methodProxy.invokeSuper(o, objects);
        System.out.println(">>>>>>after invoking");
        return ret;
    }

    public static void main(String[] args) {
        CGlibAgent cGlibAgent = new CGlibAgent();
        Apple apple = (Apple) cGlibAgent.getInstance(new Apple());
        apple.show();
    }
}
