package com.algorithms.leetCode.JZ.thinking;

public class JZ62 {
    /**
     * 约瑟夫环问题
     * @param n
     * @param m
     * @return
     */
    static public int lastRemaining(int n, int m) {
        if(n < 1 || m <1){
            return -1;
        }
        int num = 0;
        for(int i=2;i<n+1;i++){
            num = (num+m)% i;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(6,3));

    }

}
