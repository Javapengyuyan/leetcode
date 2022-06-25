package com.javaBasic.concureent.concureentList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @author: long
 * @create: 2022-05-19 22:25
 * @Description 线程安全的集合类：1、Blocking-基于锁。2、CopyOnWrite。
 *              3、Concurrent类容器：使用cas优化、弱一致性。
 **/

public class CollectionsDemo01 {
    public static void main(String[] args) {

        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        /*method(()->new ConcurrentHashMap<String, LongAdder>(),
                (map,words)->{
                    for (String word: words) {
                        map.computeIfAbsent(word,(key)->new LongAdder());
                        value.increment;
                    }
                }
                );*/


    }

    //单词计数
    public static <V> void method(Supplier<Map<String,V>> supplier, BiConsumer<Map<String,V>, List<String>> consumer){
        Map<String, V> countMap = supplier.get();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int idx = i;
            Thread thread = new Thread(()->{
                List<String> words = readFromFile(idx);
                consumer.accept(countMap,words);
            });
            ts.add(thread);
        }
        ts.forEach(thread -> thread.start());
        ts.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(countMap);

    }

    private static List<String> readFromFile(Integer idx) {
        return null;
    }

    public void test(){
        HashMap<Object, Object> map = new HashMap<>();
        //装饰器模式
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(map);
    }

}
