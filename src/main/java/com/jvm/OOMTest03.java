package com.jvm;

import java.util.ArrayList;

/**
 * @author: long
 * @create: 2022-02-27 17:22
 * @Description 测试方法区和运行时常量池溢出 RuntimeConstantPoolOOM{}
 *
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 结果：jdk1.6会出现“PermGen space”，1.7就不会了jdk1.7会一直运行下去
 *
 **/

public class OOMTest03 {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        int i=0;
        while (true){
            strings.add(String.valueOf(i++).intern());
        }

    }
}
