package niuke.剑指offer.线性表;

import niuke.common.ListNode;

import java.util.LinkedList;

public class DataStructures02 {

    /**
     * 头插法；
     * 先取出中间节点，将头节点指针后移到下一个节点
     * 取出的节点的下一个节点设置为头节点
     */

    /**
     * 03 单链表，反向输出每个节点
     * 解：①输入栈中，弹出
     * 能用栈很自然想到递归！
     * 解：②递归输出，先输出后面节点
     */
    public void revser(ListNode head){
        if (head == null) return;
        if (head.next != null){
            revser(head.next);
        }
        System.out.println(head.val);
    }

    /**
     * 05 带头节点的单链表就地逆置。（就地：扩展空间为O(1)）
     *
     * 解：链表分为头插法、尾插法两种。头部节点取下来，直接头插法。
     * 头插法解：
     */
    public ListNode reverse(ListNode head){
        if (head == null) return null;
        ListNode a = head.next;
        head.next = null;
        while (a.next != null){
            ListNode b = a.next;
            a.next = head.next;
            head.next = a;
            a = b;
        }
        return a;

    }


    /**
     * 数据结构第二章第21题
     * 题目：给定一个链表，头节点。要求返回指定倒数第k个位置的数
     */
    /**
     * 解：给定两个指针p、q，p先移动k个节点，然后p、q一起移动，当p移动到末尾时候
     * q所在位置及为倒数第k个
     * @param head
     * @param k
     * @return
     */
    public ListNode findNode(ListNode head,int k){
        if (head == null) return null;
        ListNode find = head;
        ListNode q = head;
        int i=0;
        while (i<k){
            find = find.next;
        }
        while (find.next != null){
            find = find.next;
            q = q.next;
        }
        return q;
    }

    /**
     * 第22题 头节点单链表保存数据，字母后几位相同时，可以存放在相同地址
     */
    /**
     * 解：计算两个链表的长度，较长的指针先移动/x-y/长度，然后同步移动查找
     * @param x
     * @param y
     * @return
     */
    public ListNode findSameNode(ListNode x,ListNode y){
        int xlength = listNodeLength(x);
        int ylength = listNodeLength(y);
        int num = xlength-ylength;
        if (num>0){
            for (int i =0;i<num;i++){
                x = x.next;
            }
        }else {
            for (int i=0;i<num;i++){
                y = y.next;
            }
        }
        while (x.next != null && y.next != null){
            if (x.value.equals(y.value)){
                return x;
            }
            x = x.next;
            y = y.next;
        }
        return null;
    }
    public int listNodeLength(ListNode listNode){
        if (listNode == null) return 0;
        int i=1;
        while (listNode.next != null){
            listNode = listNode.next;
            i++;
        }
        return i;
    }



}
