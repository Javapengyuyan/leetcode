package com.algorithms.leetCode.ArrayAndList;

import com.algorithms.niuke.common.ListNode;


/**
 * 数组链表相关专题
 */
public class Code {

    /**
     *  两个反转链表相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;
        int preSum = 0;
        while (l1!= null || l2 != null){
            int val1 = l1!=null ? l1.val : 0;
            int val2 = l2!=null ? l2.val : 0;
            int sum = val1 + val2 + preSum;
            if (head == null){
                head = tail = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            preSum = sum/10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }
        if (preSum > 0){
            tail.next = new ListNode(preSum);
        }
        return head;
    }


}
