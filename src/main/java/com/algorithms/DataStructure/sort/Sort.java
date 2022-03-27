package com.algorithms.DataStructure.sort;

import java.util.Arrays;

public class Sort {
    /**
     * 排序算法
     * 分类：1、交换。冒泡、快排
     *      2、插入。简单插入、希尔
     *      3、选择。简单选择、堆
     *      4、归并。二路、多路
     *
     */
    public static void main(String[] args) {
        int[] ints = {7,2,8,3,5,1,9};
        int[] in2 = {2,7,8};
        //int[] merge = merge(in2, ints);
        System.out.println(Arrays.toString( sort(ints) ));

    }

    /**
     * 归并排序: 分治思想
     * 时间复杂度 O(nlogn)
     * 空间复杂度
     *
     * Arrays.copyOfRange：拷贝数组
     *
     */
    //法一
    //1、两个合并，再两个合并
    static public int[] sort(int[] ints){
        if (ints.length<2){
            return ints;
        }
        int mid = ints.length/2;
        int[] leftArray = Arrays.copyOfRange(ints, 0, mid);
        int[] rightArray = Arrays.copyOfRange(ints, mid, ints.length);
        //注意递归，是分开merge
        return merge(sort(leftArray),sort(rightArray));

    }

    //合并时候注意最后两个问题
    static private int[] merge(int[] left, int[] right) {
        int[] ints = new int[left.length+right.length];
        int i=0,j=0;
        while (i+j<=ints.length && i<left.length && j<right.length){
            if (left[i]<=right[j]){
                ints[i+j] = left[i];
                i++;
            }else {
                ints[i+j] = right[j];
                j++;
            }
        }

        while (i<left.length){
            ints[i+j] = left[i];
            i++;
        }
        while (j<right.length){
            ints[i+j] = right[j];
            j++;
        }

        return ints;
    }

    /**
     * 归并
     * 法二：
     */
    int tmp[];
    public void mergeSort(int[] nums,int left,int right){
        if (left>=right){
            return;
        }
        int mid = (left+right)>>1;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        int i = left,j =mid+1;
        int cnt = 0;
        while (i<=mid && j<= right){
            if (nums[i]<=nums[j]){
                tmp[cnt++]=nums[i++];
            }else {
                tmp[cnt++]=nums[j++];
            }
        }
        while (i<=mid) {
            tmp[cnt++]=nums[i++];
        }
        while (j<=mid) {
            tmp[cnt++]=nums[j++];
        }
        for (int k = 0; k < right - left + 1; ++k) {
            nums[k + left] = tmp[k];
        }

    }



}
