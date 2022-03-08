package com.spring.reflect;

import com.spring.reflect.common.ApplicationContext;
import com.spring.reflect.service.impl.IBookServiceImpl;

public class BootStrap {

    public static void main(String[] args) {
        //测试反射读取配置文件加载实例对象
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.initContextByAnnotation();
        //"com.spring.reflect.service.impl.IBookServiceImpl"
        //System.out.println(IBookServiceImpl.class.getName());
        Object bean = applicationContext.getBean(IBookServiceImpl.class);
        System.out.println(bean);
    }

}
