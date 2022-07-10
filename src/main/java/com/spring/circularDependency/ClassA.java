package com.spring.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: long
 * @create: 2022-06-24 09:19
 * @Description 循环依赖问题
 **/
@Component
public class ClassA {

    @Autowired
    @Resource
    private ClassB classB;

    public ClassB getClassB() {
        return classB;
    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }
}
