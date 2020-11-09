package niuke.剑指offer.线性表;

import niuke.common.ListNode;

import java.util.Stack;

public class jz6 {
    public static void main(String[] args) {
        //反序打印列表

    }
    //借助栈
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        //创建指针，指向链表。好像不需要
        ListNode listNode = head;
        if ( listNode.next != null ){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        int[] ints = new int[stack.size()];
        for (int i=0;stack.isEmpty();i++){
            ints[i] = stack.pop();
        }
        return ints;
    }

    //不借助栈
    public int[] reversePrint2(ListNode head){

        return null;
    }

}
