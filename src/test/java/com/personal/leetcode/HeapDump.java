package com.personal.leetcode;

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

}
