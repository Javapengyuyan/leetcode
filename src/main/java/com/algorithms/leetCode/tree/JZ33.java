package com.algorithms.leetCode.tree;

public class JZ33 {

    public static void main(String[] args) {
        //int[] ints = {1,6,3,2,5};
        int[] ints = {1,3,2,6,5};
        boolean b = verifyPostorder(ints);
        System.out.println(b);
    }

    static public boolean verifyPostorder(int[] postorder) {

        return recur(postorder,0,postorder.length-1);

    }

    static boolean recur(int[] postorder,int i,int j){
        //缺少的
        if (i>=j){
            return true;
        }

        int m = i;
        while (postorder[m]<postorder[j]){
            m++;
        }
        /*while (m<j){
            if (postorder[m]>postorder[j]){
                break;
            }
            m++;
        }*/
        int p = m;
        while (postorder[p]>postorder[j]){
            m++;
        }
        /*while (m+1<j){
            if (postorder[m+1]<postorder[j]){
                return false;
            }
            m++;
        }*/
        if (m == j){
            return true;
        }
        return recur(postorder,i,p-1) && recur(postorder,p,j-1);

    }

}
