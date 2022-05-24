package com.algorithms.leetCode.Hot100.Arrays;

/**
 * @author: long
 * @create: 2022-03-30 22:04
 * @Description 数组相关
 **/

public class ArrayTest {

    public static void main(String[] args) {
        int[] ints = {5,7,7,8,8,10};
        int[] ints1 = searchRange(ints, 6);
        System.out.println(ints1);

    }

    static public int[] searchRange(int[] nums, int target) {

        int start = -1,end = -1,num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                if (start == -1){
                    start =i;
                }
                num++;
            }
        }
        end = start + num-1;
        if (start == -1){
            end+=1;
        }
        int[] r = new int[]{start,end};
        return r;
    }
}
