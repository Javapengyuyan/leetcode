package com.spring.Proxy.JdkProxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectProxy {

    @Pointcut("execution(* *com.spring.Proxy.JdkProxy.*.*(..))")
    public void pointCut(){

    }


    @Before("pointCut()")
    public void before(){
        System.out.println("before");
    }

}
