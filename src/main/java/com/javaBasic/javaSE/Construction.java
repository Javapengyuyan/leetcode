package com.javaBasic.javaSE;

public class Construction {
    int x;
    String value;
    int y;

    //构造方法
    /**
     * 构造方法是用来创建实例（初始化对象的，基本类型初始化都有默认值）
     * 提供对应的默认值
     */
    public Construction(){
        System.out.println("默认构造方法");
        System.out.println("int:"+x+" String:"+value);

    }

    public Construction(int wide,int length){
        this.x= wide;

    }
    public Construction(int wide,int length,int hide){
        //使用this调用构造方法时候必须放在第一行，否则报错
        this(length,hide);
        this.x= wide;
    }

    public static void main(String[] args) {
        Construction construction = new Construction();
        //普通方法中无法调用构造方法
        //this.();
    }



}
