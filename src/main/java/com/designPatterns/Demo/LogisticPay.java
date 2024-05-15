package com.designPatterns.Demo;

/**
 * @author: long
 * @create: 2023-08-22 17:01
 * @Description
 **/

public class LogisticPay implements CategoryFactory {
    @Override
    public String transform() {
        return "LogisticPay transform";
    }

    @Override
    public String createOrder() {
        return "LogisticPay createOrder";
    }

    @Override
    public String afterNotify() {
        return "LogisticPay afterNotify";
    }
}
