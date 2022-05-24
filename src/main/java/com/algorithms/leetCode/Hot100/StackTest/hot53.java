package com.algorithms.leetCode.Hot100.StackTest;

/**
 * @author: long
 * @create: 2022-04-14 20:55
 * @Description
 **/

public class hot53 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);

    }

    /**
     * 我觉得这道题目的思想是： 走完这一生 如果我和你在一起会变得更好，
     * 那我们就在一起，否则我就丢下你。 我回顾我最光辉的时刻就是和不同人在一起，
     * 变得更好的最长连续时刻
     *
     * 解题思路：1、用数学表达式来描述题目。2、写出公式。3、通过计算机赋值特性完成递归
     *
     */
    static public int maxSubArray(int[] nums) {
        if (nums.length<1){
            return 0;
        }
        int biggest = nums[0],pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            biggest = Math.max(biggest,pre);
        }
        return biggest;
    }




    /**
     * 暴力破解，太慢了、效率低下。
     * 问题：超出时限
     * @param nums
     * @return
     */
    static public int maxSubArray2(int[] nums) {
        int biggest = -Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (biggest<sum){
                    biggest = sum;
                }
            }
        }
        return biggest;
    }
}
