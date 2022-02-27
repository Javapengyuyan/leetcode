package com.jvm;

/**
 * @author: long
 * @create: 2022-02-27 16:44
 * @Description 虚拟机栈、本地方法栈溢出测试
 * JavaVMStackSOF;
 * 设置：-Xss128k
 *
 **/

public class OOMTest02 {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        OOMTest02 oomTest02 = new OOMTest02();
        oomTest02.stackLeak();

    }
}
