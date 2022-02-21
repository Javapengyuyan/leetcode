package com.spring.Proxy.MyCGLibTest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author: long
 * @create: 2022-02-20 14:47
 * @Description
 **/

public class MainInterface {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserInterface.class);
        enhancer.setCallback( (MethodInterceptor)(o, method, objects, methodProxy)->{
            System.out.println("切面逻辑...");
            return null;
        } );
        UserInterface userInterface = (UserInterface) enhancer.create();
        userInterface.test();

    }
}

interface UserInterface{
    void test();
}
