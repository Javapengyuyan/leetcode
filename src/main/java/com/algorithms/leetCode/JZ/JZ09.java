package com.algorithms.leetCode.JZ;

import java.util.Deque;
import java.util.LinkedList;

public class JZ09 {

    Deque<Integer> queue1;
    Deque<Integer> queue2;

    public JZ09() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        queue1.add(value);
    }

    public int deleteHead() {

        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if (!queue2.isEmpty()){
                return queue2.pop();
            }else if(queue1 != null){
                queue2.add(queue1.poll());
            }
        }
        return -1;

    }
}
