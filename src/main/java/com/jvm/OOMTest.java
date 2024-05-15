package com.jvm;

import com.google.common.cache.CacheBuilder;

import java.util.ArrayList;

/**
 * @author: long
 * @create: 2022-02-27 16:10
 * @Description
 *
 * -Xmx：堆最大值，-Xms堆最小值，-Xxs设置栈容量
 *
 * 测试jvm各个组成的oom情况
 * 前情提要：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 *  设置vm参数：
 *  -XX:+HeapDumpOnOutOfMemoryError
 *  含义：虚拟机出现内存溢出异常时Dump当前内存堆转储快照，方便分析
 **/

public class OOMTest {

    static class OOMObject{}

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }

    }
}
