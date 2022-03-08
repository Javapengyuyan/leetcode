package com.javaBasic.javaSE.genericT.demo10;

import java.util.ArrayList;

/**
 * @author: long
 * @create: 2021-12-28 17:28
 * @Description
 **/

public class Test10 {

    public static void main(String[] args) {

        //ArrayList<String>[] arrayList = new ArrayList<String>[5];
        ArrayList<String>[] arrayList = new ArrayList[5];
        ArrayList array = new ArrayList();
        array.add("a");
        array.add(1);
        arrayList[0] = array;
        String s = arrayList[0].get(0);
        //这个就会报错 ClassCastException
        String s1 = arrayList[0].get(1);
        System.out.println(arrayList);

    }

}
