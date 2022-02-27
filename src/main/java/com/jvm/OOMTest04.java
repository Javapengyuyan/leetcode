package com.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: long
 * @create: 2022-02-27 18:08
 * @Description JavaMethodAreaOOM测试内存溢出
 *
 * -XX:PermSize=10M -XX:MaxPerSize=10M  java8中已经废弃
 *
 * -XX:MetaspaceSize和-XX:MaxMetaspaceSize代替
 *
 **/

public class OOMTest04 {
    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,args);
                }
            });
            enhancer.create();

        }

    }

    static class OOMObject{

    }

}
