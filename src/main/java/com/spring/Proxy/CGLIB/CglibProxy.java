package com.spring.Proxy.CGLIB;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    //被代理对象 目标对象
    private Object target;

    public Object createProxy(Object target){
        this.target = target;
        //最核心得代码 通过cglib增强代理
        Enhancer enhancer = new Enhancer();//用来生成代理的工厂类
        //生成目标类对象的子类 进行增强
        //设置被代理的类的类型type
        enhancer.setSuperclass(target.getClass());
        //如何增强 你需要告诉我
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;

    }


    /**
     * 描述如何增强父类
     * @param proxy 代理对象引用
     * @param method 被代理对象的方法的描述引用
     * @param args 方法的参数
     * @param methodProxy 代理对象的对目标对象的方法的描述
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("my--intercept调用");
        MyAspect myAspect = new MyAspect();
        myAspect.check_permission();
        //调用原始方法
        //1代理类对象进行调用
        Object invokeSuper = methodProxy.invokeSuper(proxy, args);
        //2原对象
        //Object invoke = method.invoke(target, args);
        myAspect.cat_log();
        return invokeSuper;
    }

    public static void main(String[] args) {
        UserDao target = new UserDao();
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = (UserDao) cglibProxy.createProxy(target);
        userDao.saveUser();
    }
}
