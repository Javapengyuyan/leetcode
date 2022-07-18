package com.spring.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: long
 * @create: 2022-06-24 13:21
 * @Description 模拟spring的一级、二级、三级缓存模式
 **/

public class MainStart {
    private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public static void loadBeanDefinitions(){
        RootBeanDefinition aBeanDefinition = new RootBeanDefinition(InstanceA.class);
        RootBeanDefinition bBeanDefinition = new RootBeanDefinition(InstanceB.class);
        beanDefinitionMap.put("instanceA",aBeanDefinition);
        beanDefinitionMap.put("instanceB",bBeanDefinition);

    }

    public static void main(String[] args) {
        loadBeanDefinitions();
    }

    //一级缓存
    public static Map<String,Object> singletonObjects = new ConcurrentHashMap<>();
    //二级缓存
    public static Map<String,Object> earlySingletonObjects = new ConcurrentHashMap<>();

    /**
     * 获取bean
     * @return
     */
    public static Object getBean(String beanName) throws Exception {

        Object singleton = getSingleton(beanName);
        if (singleton != null){
            return singleton;
        }
        /**
         * 1、实例化
         * 模拟采用属性赋值方式实例化
         */
        RootBeanDefinition beanDefinition = (RootBeanDefinition) beanDefinitionMap.get(beanName);
        Class<?> beanClass = beanDefinition.getBeanClass();
        //调用无参函数实例化
        Object instanceBean = beanClass.newInstance();

        JdkProxyBeanPostProcessor jdkProxyBeanPostProcessor = new JdkProxyBeanPostProcessor();

        /**
         * 放到二级缓存
         */
        earlySingletonObjects.put(beanName,instanceBean);

        /**
         * 2、属性赋值
         */
        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field declaredField:declaredFields) {
            //判断属性是否有@Awtowired注解
            Autowired annotation = declaredField.getAnnotation(Autowired.class);
            if (annotation != null){
                //设置可访问
                declaredField.setAccessible(true);
                String name = declaredField.getName();
                Object fileObject = getBean(name);
                //为属性设置类型
                declaredField.set(instanceBean,fileObject);
            }

        }
        /**
         * 放入到一级缓存中
         *
         * 一级缓存问题：a、b都引用c，a创建c后放入到缓存中，此时b进行调用执行到创建c，然后从缓存中拿到c，此时的
         * c是不完整的、没有进行赋值
         */
        singletonObjects.put(beanName,instanceBean);

        /**
         * 第四步：初始化
         */
        return instanceBean;

    }

    private static Object getSingleton(String beanName) {
        if (singletonObjects.get(beanName) != null){
            return singletonObjects.get(beanName);
        }else if ( earlySingletonObjects.containsKey(beanName) ){
            return earlySingletonObjects.get(beanName);
        }else {
            return null;
        }

    }


}
