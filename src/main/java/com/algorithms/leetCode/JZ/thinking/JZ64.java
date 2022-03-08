package com.algorithms.leetCode.JZ.thinking;

public class JZ64 {
    static int sum;
    static public int sumNums(int n) {
        boolean b = n>1 && sumNums(n-1) >0;
        sum +=n;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(9));
    }

}
