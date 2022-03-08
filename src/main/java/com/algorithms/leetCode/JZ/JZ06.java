package com.algorithms.leetCode.JZ;

import com.algorithms.niuke.common.ListNode;

import java.util.Stack;

public class JZ06 {

    public int[] reversePrint(ListNode head) {

        Stack stack = new Stack();
        while (head.next != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ints = new int[stack.size()-1];
        for (int i=0;i<ints.length;i++){
            ints[i] = (int) stack.pop();
        }
        return ints;
    }

}
