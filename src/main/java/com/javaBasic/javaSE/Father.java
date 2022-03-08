package com.javaBasic.javaSE;

public class Father {

    /**
     * 父类也叫做超类
     */
    public String jump(){
        System.out.println("这是父类public方法输出");
        return null;
    }

    protected  String run(){
        System.out.println("这是父类protected方法输出");
        return null;
    }

}
