package com.algorithms.leetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class SameNumber {
    public int findRepeatNumber(int[] nums) {
        Set set = new HashSet();
        int num = -1;
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i])){
                num = nums[i];
                System.out.println(nums[i]);
                break;
            }else {
                set.add(nums[i]);
            }
        }
        return num;
    }

}
