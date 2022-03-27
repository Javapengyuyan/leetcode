package com.algorithms.DataStructure.sort;

import java.util.Arrays;

/**
 * @author: long
 * @create: 2022-03-25 14:09
 * @Description 选择排序
 *
 *   选择排序:
 *          简单选择：每次选择最小的数，交换位置
 *              时间复杂度 O(n²)
 *              空间复杂度
 *
 *          堆选择
 *              时间复杂度 O(nlogn)
 **/

public class SelectionSort {

    public static void main(String[] args) {
        int[] ints= new int[]{5,2,3,1};
        int[] select = heapSort(ints);
        System.out.println(Arrays.toString(select));
    }

    /**
     * 堆排序
     *
     */
    static public int[] heapSort(int[] nums){
        int length = nums.length-1;
        buildMaxHeap(nums,length);
        for (int i = length;i>=1;--i){
            swap(nums,i,0);
            length-=1;
            maxHeapify(nums,0,length);
        }
        return nums;
    }

    static private void buildMaxHeap(int[] nums, int length) {
        for (int i = length/2; i >0 ; --i) {
            maxHeapify(nums,i,length);
        }
    }
    static private void maxHeapify(int[] nums, int i, int len) {
        int left = 2 * i +1;
        int right = 2 * i +2;
        int largest = i;
        if (left<len && nums[left]>nums[largest]){
            largest = left;
        }
        if (right<len && nums[right]>nums[largest]){
            largest= right;
        }
        if (largest != i){
            swap(nums,i,largest);
            maxHeapify(nums,largest,len);
        }
    }

    /**
     * 简单排序
     * 辣鸡，不要用
     */
    static public int[] select(int[] ints){
        if (ints.length<2){
            return ints;
        }
        for (int i = 0; i < ints.length; i++) {
            for (int j = i+1; j < ints.length; j++) {
                if (ints[j]<ints[i]){
                    swap(ints,i,j);
                }
            }
        }
        return ints;
    }

    static public int[] swap(int[] ints,int i,int j){
        int num = ints[i];
        ints[i] = ints[j];
        ints[j] = num;
        return ints;
    }

}
