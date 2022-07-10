package com.spring.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: long
 * @create: 2022-06-24 10:24
 * @Description
 **/
@Component
public class ClassB {

    @Autowired
    private ClassA classA;

    public ClassA getClassA() {
        return classA;
    }

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }
}
