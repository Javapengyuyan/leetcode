package com.spring.circularDependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

/**
 * @author: long
 * @create: 2022-07-18 16:46
 * @Description
 **/

public class JdkProxyBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {


    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if (bean instanceof InstanceA){
            //JdkDynimcProxy jdkDynimcProxy = new JdkDynimcProxy(bean);
            //return jdkDynimcProxy.getProxy;
        }

        return null;
    }
}
