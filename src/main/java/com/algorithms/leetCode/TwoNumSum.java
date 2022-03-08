package com.algorithms.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoNumSum {

    /**
     * 给定一个数sum，给定一个数组int[]，求是否包含两个数和为sum，返回结果每个数只能用一次
     *
     * 利用map的无序性减少循环遍历次数，变为O(1)
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int[] array = new int[]{1,3,5,6,9};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<array.length;i++){
            if (map.containsKey(sum-array[i])){
                System.out.println(i+","+map.get(sum-array[i]));
                return;
            }
            map.put(array[i],i);
        }

    }
}
