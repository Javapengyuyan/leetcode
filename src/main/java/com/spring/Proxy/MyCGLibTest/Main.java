package com.spring.Proxy.MyCGLibTest;

import com.spring.Proxy.StaticProxy.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: long
 * @create: 2022-02-20 14:36
 * @Description
 **/

public class Main {
    public static void main(String[] args) {
        final MyUserService target = new MyUserService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyUserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("test")){
                    System.out.println("before");
                    method.invoke(target,objects);
                    System.out.println("after");
                    return null;
                }

                return method.invoke(target,objects);
            }
        });

        MyUserService myUserService = (MyUserService) enhancer.create();
        myUserService.test();

    }
}

class MyUserService implements UserService {

    @Override
    public String send(String name) {
        return null;
    }

    @Override
    public void test() {
        System.out.println("test");
    }
}

