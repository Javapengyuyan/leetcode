package com.spring.IOC;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author: long
 * @create: 2023-01-19 16:31
 * @Description
 **/

public class Demo implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
