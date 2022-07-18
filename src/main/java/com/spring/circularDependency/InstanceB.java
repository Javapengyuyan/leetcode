package com.spring.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: long
 * @create: 2022-06-24 10:24
 * @Description
 **/
@Component
@Scope("prototype")
public class InstanceB {

    @Autowired
    private InstanceA classA;

    public InstanceA getClassA() {
        return classA;
    }

    public void setClassA(InstanceA classA) {
        this.classA = classA;
    }
}
