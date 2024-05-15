package com.personal.leetcode.Test;

import java.util.Scanner;

public class FB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        System.out.println(fb(n));

    }

    public static int fb(Integer n){
        int a=0,b=1,sum;
        for (int i=0;i<n;i++){
            sum = a + b;
            a= b;
            b = sum;
        }
        return a;
    }

}
