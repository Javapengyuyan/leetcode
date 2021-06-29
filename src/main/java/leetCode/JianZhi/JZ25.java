package leetCode.JianZhi;

import niuke.common.ListNode;

public class JZ25 {

    /**
     * 伪头节点
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(l1,l2));

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

}
