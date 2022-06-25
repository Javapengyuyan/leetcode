package com.spring.Proxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicAgent {

    static class MyHander implements InvocationHandler{

        private Object proxy;
        public MyHander(Object proxy){
            this.proxy = proxy;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>>>>before invoking");
            System.out.println("调用方法的真实名称："+method.getName()+args);
            Object ret = method.invoke(this.proxy, args);
            System.out.println(">>>>>after invoking");
            return ret;
        }
    }

    /**
     * 生产代理对象实例
     * @param interfaceClazz
     * @param proxy
     * @return
     */
    public static Object agent(Class interfaceClazz,Object proxy){
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(),
                new Class[]{interfaceClazz},new MyHander(proxy));
    }

}
