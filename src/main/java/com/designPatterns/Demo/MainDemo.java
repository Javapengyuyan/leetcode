package com.designPatterns.Demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: long
 * @create: 2023-08-22 16:54
 * @Description 设计个计算器
 **/
@Slf4j
public class MainDemo {

    public static void main(String[] args) {
        CategoryFactory categoryFactory = new LogisticPay();
        categoryFactory.afterNotify();

        CreateFactory createFactory = new CreateFactory();
        String s = createFactory.create(categoryFactory);
        log.info("生成：{}",s);


    }

}
