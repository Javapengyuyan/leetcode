package com.spring.circularDependency;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: long
 * @create: 2022-06-24 13:21
 * @Description
 **/

public class MainStart {
    private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public static void loadBeanDefinitions(){
        RootBeanDefinition aBeanDefinition = new RootBeanDefinition(ClassA.class);
        RootBeanDefinition bBeanDefinition = new RootBeanDefinition(ClassB.class);
        beanDefinitionMap.put("instanceA",aBeanDefinition);
        beanDefinitionMap.put("instanceB",bBeanDefinition);

    }

    public static void main(String[] args) {
        loadBeanDefinitions();
    }


}
