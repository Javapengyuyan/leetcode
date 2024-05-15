package com.personal.leetcode;

import com.spring.circularDependency.InstanceA;
import com.spring.circularDependency.InstanceB;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOutOfMemoryError
 *
 */
public class HeapDump {

    static class OOMOjbect{}

    public static void main(String[] args) {
        List<OOMOjbect> list = new ArrayList<>();
        while (true){
            list.add(new OOMOjbect());
        }

    }

    @Test
    public void beanTest(){
        InstanceA classA = new InstanceA();
        InstanceB classB = new InstanceB();
        System.out.println("测试");
    }

}
