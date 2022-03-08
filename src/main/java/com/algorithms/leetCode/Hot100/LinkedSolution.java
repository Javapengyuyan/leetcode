package com.algorithms.leetCode.Hot100;

import com.algorithms.niuke.common.ListNode;

public class LinkedSolution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next =new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        removeNthFromEnd(head,3);

    }

    static public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }
        int start = 0;
        ListNode removeNode = new ListNode(head.val);
        removeNode = head;
        ListNode endNode = new ListNode(head.val);
        endNode = head;
        while (endNode != null){
            if (start > n){
                removeNode = removeNode.next;
            }
            endNode = endNode.next;
            start++;
        }
        //移除指定节点
        removeNode.next = removeNode.next.next;

        return head;
    }


}
