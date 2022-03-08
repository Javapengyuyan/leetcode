package com.javaBasic.javaSE.genericT.demo5;

/**
 * @author: long
 * @create: 2021-12-13 20:38
 * @Description 实现泛型接口的类不是泛型类时候，需要明确接口类型。不写默认Object类型
 *
 **/

public class Apple implements Generator<String>{
    @Override
    public String getKey() {
        return "hello generator";
    }

    /*@Override
    public Object getKey() {
        return null;
    }*/

}
