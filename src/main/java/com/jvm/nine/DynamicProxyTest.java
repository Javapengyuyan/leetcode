package com.jvm.nine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: long
 * @create: 2023-02-07 12:17
 * @Description
 **/

public class DynamicProxyTest {

    interface IHello{
        void sayHello();
    }

    static class Hello implements IHello{
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
    }


    static Object originalObj;

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("welcome");
                return null;
            }
        };

        IHello iHello = (IHello) Proxy.newProxyInstance(
                originalObj.getClass().getClassLoader(),
                new Class[]{IHello.class},
                handler);
        iHello.sayHello();
    }

}
