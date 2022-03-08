package com.javaBasic.javaSE.threadRunnable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author: long
 * @create: 2021-12-29 14:27
 * @Description
 **/

public class Man {

    public static ThreadLocal<SimpleDateFormat> simpleDateFormatLocal = new ThreadLocal<SimpleDateFormat>(){

        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        ArrayList arrayList = new ArrayList();
        Iterator iterator = arrayList.iterator();
        Object next = iterator.next();
        while (iterator.hasNext()){
            if (iterator.equals("a")){
                iterator.remove();
            }
        }
        ListIterator listIterator = (ListIterator) new ArrayList<Integer>();
        //Comparator.comparing();


    }


}
