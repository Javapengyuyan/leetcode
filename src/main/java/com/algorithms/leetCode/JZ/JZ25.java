package com.algorithms.leetCode.JZ;

import com.algorithms.niuke.common.ListNode;
import com.algorithms.niuke.common.Node;

import java.util.HashMap;

public class JZ25 {

    /**
     * 伪头节点
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        /*ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(l1,l2));*/
        reverseList(l1);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null){

        }
        ListNode lastList = new ListNode(-1);
        ListNode cur = lastList;
        while (l1 != null && l2 != null){
            int a = l1.val;
            int b = l2.val;
            if (a < b){
                cur.next = l1;
                l1 = l1.next;

            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;

        }
        return cur.next;

    }

    //24、找一个中间变量传递值
    public static ListNode reverseList(ListNode head){
        if (head == null){
            return head;
        }
        ListNode pre = null,cur= head;
        while (cur.next != null){
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        //!!!! 注意返回节点的next节点
        cur.next = pre;
        return cur;
    }


    //2 3
    public void rever(ListNode head,ListNode next){
        ListNode node = next.next;//4
        next.next = head;
        rever(next,node);
    }



    //JZ35 复制链复杂链表---hash方法
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node random = head.random;
        //复制基本链表，存放hash值
        /* 这种写法有bug，如果是最后一个节点就会忽略
        Node cur = new Node(head.val);
        Node pre = null;
        while (head.next != null){
            Node next = head.next;
            cur.next = next;
            pre.next = cur;
            pre = cur;
            cur = next;
        }*/
        HashMap<Node,Node> map = new HashMap();
        //复制基本链表，存放hash值
        Node dum = new Node(0),pre=dum;
        Node cur = head;
        while (cur != null){
            Node node = new Node(cur.val);
            map.put(node,cur);
            pre.next = node;
            cur = cur.next;
            pre = node;
        }
        Node cur2 = dum.next;
        while (cur2 != null){
            cur2.random = map.get(cur2).random;
            cur2 = cur2.next;
        }
        return dum.next;
    }




}
