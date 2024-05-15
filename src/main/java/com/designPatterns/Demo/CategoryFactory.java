package com.designPatterns.Demo;

/**
 * @author: long
 * @create: 2023-08-22 15:32
 * @Description 工厂创建，模板、策略选择
 **/

public interface CategoryFactory {

    String transform();

    String createOrder();

    String afterNotify();

}
