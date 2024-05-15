package com.algorithms.leetCode.JZ;

/**
 * @author: long
 * @create: 2023-03-20 22:45
 * @Description
 **/

public class JZ53 {

    public static void main(String[] args) {
        int[] ints = {5,7,7,8,8,10};
        int search = search(ints, 6);
        System.out.println(search);
    }

    static public int search(int[] nums, int target) {
        if (nums == null){
            return 0;
        }
        int total = 0;
        int where = -1;
        int i=0,j=nums.length;
        while (i<=j){
            int mid = (i+j)/2;
            int num =nums[mid];
            if (num < target){
                i= mid;
            }else if (num > target){
                j = mid;
            }else if (num == target){
                where = mid;
                total++;
                break;
            }
        }
        if (total == 0){
            return total;
        }
        int left=where-1,right=1+where;
        while (left>0){
            if (nums[left] == target){
                total++;
            }
            left--;
        }
        while (right<nums.length-1){
            if (nums[right] == target){
                total++;
            }
            right++;
        }
        return total;
    }
}
