package com.personal.leetcode.Test;

import com.algorithms.niuke.common.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String args[]) {

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (2 == next){
                iterator.remove();
            }
        }
        System.out.println(arrayList);

        int[] arr = new int[]{1,0,7,6,5,4,9,3};
        int[] index = new int[]{0,4,3,1,2,0,5,4,3,6,7};
        String tel = "";
        for (int i:index) {
            tel +=arr[i];
        }
        System.out.println(tel);


        /*Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(minAdd(input));
        }*/

    }

    static public int minAdd(String string) {
        char[] str = string.toCharArray();
        int len = str.length;
        int[][] vec = new int[len][len];//用于存储字符串从i位置到j位置构成汇文串需要最少添加的字符数量
        for(int k = 1 ; k < len ; k ++) {//i位置与j位置的间隔（自字符串长度-1），一般情况下，拆分成最小子问题时，k的初始值应为0，但因java创建数组是已经对每一个节点赋予了初始值0，故k为0时可以省略
            for(int i = 0; i+k < len ; i++) {
                int j = i + k ;
                if(str[i]==str[j]) {
                    vec[i][j]=vec[i+1][j-1];
                }else {
                    vec[i][j]=Math.min(vec[i+1][j],vec[i][j-1])+1;
                }
            }
        }
        return vec[0][len-1];
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode rt = new ListNode(0);
        rt.next = head;
        ListNode result = rt;
        while (rt.next != null){
            if (rt.next.val == val){
                rt.next = rt.next.next;
            }else {
                rt = rt.next;
            }

        }
        return result.next;
    }


}