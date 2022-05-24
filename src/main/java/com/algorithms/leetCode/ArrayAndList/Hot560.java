package com.algorithms.leetCode.ArrayAndList;

/**
 * @author: long
 * @create: 2022-03-15 22:40
 * @Description 一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数
 **/

public class Hot560 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        int i = subarraySum(nums, k);
        System.out.println(i);

    }

    static public int subarraySum(int[] nums, int k) {
        int result = 0;
        int start = 0;
        int end = 0;
        while ( start<nums.length && end <nums.length && start<= end){
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum = sum+nums[i];
            }
            if (sum == k){
                result++;
                end++;
                start++;
            }else if (sum < k ){
                end++;
            }else if (sum>k){
                start++;
            }

        }
        return result;
    }

}
