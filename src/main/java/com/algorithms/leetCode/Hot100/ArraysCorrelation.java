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
        /*int[] nums1 = {}, nums2 = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums2));*/
        String s = "babad";
        String s1 = longestPalindrome2(s);
        System.out.println(s1);

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
     *  法一：使用中心扩展
     *  注意：奇数和偶数的两种情况
     *
     *  法二：使用动态规划，遍历求极值，根据状态转移方程写出代码
     *  长度小于2位的相等为ture，长度大于2的则看下一层，
     *
     * @param s 字符串
     * @return
     */
    //中心扩展法
    static public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        if (s.length()<3){
            if (chars[0] == chars[s.length()-1]){
                return s;
            }else {
                return String.valueOf(chars[0]);
            }
        }
        //这么要注意，不能默认为奇数回文，还有可能是偶数，不然会少了一半
        for (int i=0;i<s.length();i++){
            int palindrom = palindrom(chars, i, i);
            int palindrom2 = palindrom(chars, i, i+1);
            int max = Math.max(palindrom, palindrom2);
            if (max>right-left){
                left = i-(max-1)/2;
                right = i+max/2;
            }
        }
        return s.substring(left,right+1);
    }

    //计算的为向外扩展的数量
    static public int palindrom(char[] chars,int start,int end){
        while (start>-1 && end <chars.length &&  chars[start]==chars[end]){
            --start;
            ++end;
        }
        return end-start-1;//注意返回值要减一，因为如果是偶数没有扩展应该为0，所以要减一
    }

    //动态规划
    static public String longestPalindrome2(String s) {
        if (s.length()<2){
            return s;
        }
        int length = s.length();
        boolean[][] booleans = new boolean[length][length];
        // java中boolean默认false，因此要赋值初始化
        for (int i=0;i<length;i++){
            booleans[i][i] = true;
        }
        char[] chars = s.toCharArray();
        int maxLen = 0;
        int start = 0;
        //动态规划用空间换时间，进行状态转移方程
        for (int j = 0; j < length; j++) {
            for (int i =0; i < j; i++) {
                if ( chars[i]!= chars[j]){
                    booleans[i][j] = false;
                }else {
                    /**
                     * 边界条件：判断是否需要检查子串是否为回文。
                     * 去除j、i本身，有：j-1-(i+1)+1<2
                     * 转化为：j-i<3
                     */
                    if (j-i<3){
                        booleans[i][j] = true;
                    }else {
                        booleans[i][j] = booleans[i-1][j+1];
                    }
                }
                /**
                 * 二维数组为ture表示对应i、j节点为回文数，记录回文长度
                 */
                if (booleans[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxLen);
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
