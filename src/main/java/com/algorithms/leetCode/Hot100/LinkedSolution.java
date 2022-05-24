package com.algorithms.leetCode.Hot100;

import com.algorithms.niuke.common.ListNode;

/**
 * 链表
 */
public class LinkedSolution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next =new ListNode(2);
        head.next.next = new ListNode(4);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);
        //removeNthFromEnd(head,3);
        ListNode l2 = new ListNode(1);
        l2.next =new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(head,l2);

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

    /**
     * hot21
     * @param l1
     * @param l2
     * @return 头节点
     */
    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(-1);
        ListNode preNode = start;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                preNode.next = l1;
                l1 = l1.next;
            }else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1 == null ? l2 : l1;
        return start.next;
    }


}
