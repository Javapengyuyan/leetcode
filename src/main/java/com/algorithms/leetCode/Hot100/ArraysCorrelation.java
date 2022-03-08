package com.algorithms.leetCode.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysCorrelation {
    /**
     * 排序数组进行查找定位--想到二分查找
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {}, nums2 = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums2));
    }

    /**
     *
     * 这种写法不好，需要多种判断边界问题
     *
     * @param nums1
     * @param nums2
     * @return
     */
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if (sum == 1){
            int result = nums1.length ==0? nums2[0]: nums1[0];
            return result;
        }
        int mod = sum%2;
        double result = 0;
        boolean one = true;
        double mid = Math.ceil(sum/2);
        if (mod == 0){
            one = false;
        }
        int i=0,j=0,k=0;
        boolean switchij = true;
        while (i<mid){
            if (!one){
                if (i== mid-2){
                    if (switchij){
                        result += nums2[i];
                    }else {
                        result += nums1[j];
                    }
                }
            }
            if (i== mid-1){
                if (switchij){
                    result += nums2[i];
                }else {
                    result += nums1[j];
                }
            }

            if (nums1[j]<nums2[k]){
                j++;
                switchij = false;
            }else {
                k++;
            }
            i++;
        }
        return one?result:result/2;

    }

    /**
     * 要让时间复杂度变为log(m+n)用二分查找
     *
     */


    /**
     *  最长回文子串
     *  使用动态规划，遍历求极值，根据状态转移方程写出代码
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = 1;
        char[] chars = s.toCharArray();
        if (s.length()<3){
            if (chars[0] == chars[s.length()-1]){
                return s;
            }else {
                return String.valueOf(chars[0]);
            }
        }

        for (int i=0;i<s.length();i++){
            for (int j =i;j<s.length();j++){


                if (chars[i-1] == chars[j+1]){

                }

            }

        }


        return null;
    }


    /**
     * 11、盛最多水容器
     * 面积=长×宽，双指针求出最低
     * 由同号不等式相乘符号不变可得：移动大的那个数轴面积只会减少，因此移动小的那根数轴
     * @param height
     * @return
     */
    static public int maxArea(int[] height) {
        if (height.length == 0){
            return 0;
        }
        int max = 0;
        int left = 0,right = height.length-1;
        while (left != right){
            int area = Math.min(height[left],height[right])*(right-left);
            max = Math.max(max,area);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }

        }
        return max;
    }


    /**
     * 15、三数之和
     * 首先想到三重循环，一点点对比，时间复杂度过高n三次方放弃
     *
     * 双指针做法，先将数组从小到大排序，
     * 固定第一个数字，左指针向右移动增大，右指针向左移动减小，
     * 根据有序数组的规律判断指针的移动，从而减少一层循环
     * 相同数字直接跳过
     */
    static public List<List<Integer>> threeSum(int[] nums){
        if (nums.length < 3){
            return null;
        }
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        //遍历外层
        for (int first =0;first<length-1;++first){
            //相同数字跳过
            if (first>0 && nums[first] == nums[first-1]){
                continue;
            }
            //内层循环
            for (int second = first+1;second<length-1;++second){
                //相同数字跳过
                if (second >first+1 && nums[second] == nums[second-1]){
                    continue;
                }
                int third = length-1;
                if (second == third){
                    continue;
                }
                int target = -(nums[first]+nums[second]);
                while (second<third && target< nums[third] ){
                    third--;
                }
                if (second == third){
                    break;
                }

                //添加结果
                if (target == nums[third]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }

            }

        }
        return ans;
    }

    /**
     * 39、任意组合数字之和
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        

        return null;
    }



}
