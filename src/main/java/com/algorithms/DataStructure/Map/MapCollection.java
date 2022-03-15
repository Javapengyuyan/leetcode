package com.algorithms.DataStructure.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: long
 * @create: 2022-03-10 16:25
 * @Description
 **/

public class MapCollection {
    public static void main(String[] args) {
        //每次获取对象的时候加synchronized锁，锁性能和HashTable差不多。
        Collections.synchronizedMap(new HashMap<>());
        /**
         * 数组、链表、红黑树
         */
        new ConcurrentHashMap<>();

    }
}
