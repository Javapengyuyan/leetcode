package com.middleware.dubbo;

/**
 * @author: long
 * @create: 2022-05-09 22:01
 * @Description dubbo服务降级、服务容错
 **/

public class demo01 {

    public static void main(String[] args) {

    }

    //@Reference(mock = "force:return null")//降级
    //@Reference(cluster = "failover")//容错--远程注入
    public void dubboTest(){

    }


}
