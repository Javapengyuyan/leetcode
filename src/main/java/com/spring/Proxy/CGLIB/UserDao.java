package com.spring.Proxy.CGLIB;

/**
 * 目标类、被代理类
 */
public class UserDao {

    public void saveUser(){
        System.out.println("用户新增。。。。");
    }

}
