package com.spring.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: long
 * @create: 2022-06-24 09:19
 * @Description 循环依赖问题
 **/
@Component
@Scope(value = "prototype")//不使用Scope注解则bean为单例，使用Scope指定prototype则为多实例，且为懒汉模式加载。
public class InstanceA {

    @Autowired
    @Resource
    private InstanceB classB;

    public InstanceB getClassB() {
        return classB;
    }

    public void setClassB(InstanceB classB) {
        this.classB = classB;
    }
}
