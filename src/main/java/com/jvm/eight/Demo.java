package com.jvm.eight;

/**
 * @author: long
 * @create: 2022-12-23 13:44
 * @Description
 **/

public class Demo {
    static int c;
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a =0;
        System.gc();
        int b;
        //System.out.println(b);//局部变量没有初始化不能使用
        System.out.println(c);//类变量没有初始化能使用
    }
}
