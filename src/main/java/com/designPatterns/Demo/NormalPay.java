package com.designPatterns.Demo;

/**
 * @author: long
 * @create: 2023-08-22 17:14
 * @Description
 **/

public class NormalPay implements CategoryFactory{
    @Override
    public String transform() {
        return "NormalPay transform";
    }

    @Override
    public String createOrder() {
        return "NormalPay createOrder";
    }

    @Override
    public String afterNotify() {
        return "NormalPay afterNotify";
    }
}
