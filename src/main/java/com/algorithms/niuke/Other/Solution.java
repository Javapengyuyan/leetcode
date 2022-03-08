package com.algorithms.niuke.Other;

import java.util.HashSet;

public class Solution {
    public boolean makesquare (int[] matchsticks) {
        int sum = 0;
        for (int i=0;i<matchsticks.length;i++){
            sum += matchsticks[i];
        }
        int arg = sum%4;
        if (arg != 0){
            return false;
        }
        int avg = sum/4;
        for (int i=0;i<matchsticks.length;i++){
            if (matchsticks[i] > avg){
                return false;
            }
        }
        return true;
    }

    public int[] sortColors (int[] nums) {
        if (nums.length == 0){
            return nums;
        }
        int i=0,j=0,k=0;
        for (int x = 0;x<nums.length;x++){
            switch (nums[x]){
                case 0:
                    i++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    k++;
                    break;
            }
        }
        int[] result = new int[i+j+k];
        for (int a=0;a<i+j+k;a++){
            if (a<i){
                result[a]= 0;
            }else if (  a<i+j && a>=i ){
                result[a]= 1;
            }else {
                result[a]= 2;
            }
        }
        return result;

    }

    public int singleNumber (int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i=0;i<nums.length;i++){
            int num = nums[i];
            if (set.contains(num)){
                set.remove(num);
            }else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }


}
