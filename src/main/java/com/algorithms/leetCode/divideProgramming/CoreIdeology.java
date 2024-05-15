package com.algorithms.leetCode.divideProgramming;

public class CoreIdeology {

    /**
     *
     *
     */

    public void quickSort(){


    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        //int[] nums = {1};
        int i = searchInsert(nums, 2);
        System.out.printf("i" + i);
    }
    static public int searchInsert(int[] nums, int target) {
        if(nums.length < 1){
            return -1;
        }
        int num = nums.length/2;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            if(nums[start] >= target){
                return start;
            }
            if(nums[end] < target){


                return end+1;
            }
            if(nums[end] == target){
                return end;
            }
            if(nums[num] >= target){
                end = num-1;
            }else{
                start = num+1;
            }

            num = (start+end)/2;
        }
        return num;
    }



}
