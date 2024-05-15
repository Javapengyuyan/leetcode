package com.designPatterns.Demo;

import java.util.HashMap;

/**
 * @author: long
 * @create: 2023-08-22 17:09
 * @Description
 **/

public class CreateFactory {

    private static HashMap<Integer,CategoryFactory> factoryHashMap = new HashMap<>();

    /**
     * 创建时候通过策略筛选
     * @param factory
     * @return
     */
    public String create(CategoryFactory factory){
        factory.transform();
        factory.createOrder();
        String notify = factory.afterNotify();
        return notify;
    }

    public String create(Integer type){
        CategoryFactory factory = factoryHashMap.get(type);
        factory.transform();
        factory.createOrder();
        String notify = factory.afterNotify();
        return notify;
    }

}
