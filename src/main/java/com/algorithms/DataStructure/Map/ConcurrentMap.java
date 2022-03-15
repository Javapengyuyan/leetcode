package com.algorithms.DataStructure.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: long
 * @create: 2022-03-15 20:42
 * @Description  concurrentHashMap迭代器是弱一致性。hashMap是强一致性。
 **/

public class ConcurrentMap {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> chm = new ConcurrentHashMap();
        //HashMap<Integer,String> chm = new HashMap<>();
        chm.put(1,"张三");
        chm.put(2,"李四");
        chm.put(3,"王五");
        chm.put(4,"赵六");
        Iterator<String> iterator = chm.values().iterator();
        new Thread( ()->{
            chm.remove(3);
        }).start();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
