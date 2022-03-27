package com.algorithms.DataStructure.sort;

import java.util.Arrays;

/**
 * 交换排序:冒泡、快排
 * 时间复杂度，空间复杂度
 *
 */
public class ExchangeSort {

    public static void main(String[] args) {
        int[] ints = new int[]{3,5,1,8,2};
        Arrays.sort(ints);
        //ints = bubbleSort(ints);
        //ints = leftSort(ints);
        System.out.println(Arrays.toString(ints));
        quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * Bubble冒泡排序
     * @param ints
     * @return
     */
    //从左往右冒泡
    public static int[] bubbleSort(int[] ints){
        if (ints.length<2){
            return ints;
        }
        for (int i=0;i<ints.length;i++){
            for (int j= 0;j<ints.length-i-1;j++){
                if (ints[j]<ints[j+1]){
                    ints[j] = ints[j]+ints[j+1];
                    ints[j+1] = ints[j]-ints[j+1];
                    ints[j] = ints[j]-ints[j+1];
                }
            }
        }
        return ints;
    }

    //从右往左冒
    public static int[] leftSort(int[] ints){
        if (ints.length<2) return ints;
        for (int i=0;i<ints.length;i++){
            for (int j=ints.length-1;j>i;j--){
                if (ints[j]>ints[j-1]){
                    ints[j] = ints[j]+ints[j-1];
                    ints[j-1] = ints[j]-ints[j-1];
                    ints[j] = ints[j]-ints[j-1];
                }
            }
        }
        return ints;
    }

    /**
     * 快排--分治法
     * O(nlogn)，不稳定
     *
     *  步骤：1、以第一个数为基准值，基准右边一位为index，遍历一遍
     *       2、比基准小的与index交换index++。目的：遍历一边找到一个数的最终位置。核心
     *       3、遍历完成调换index和基准数
     *       4、迭代
     *
     */
    static public int[] quickSort(int[] ints){
        int left=0,right=ints.length-1;
        quick(ints,left,right);
        return ints;
    }

    //递归--迭代
    static public void quick(int[] ints,int left,int right){
        if (left< right){
            int pivot = getPartition(ints, left, right);
            quick(ints,left,pivot-1);
            quick(ints,pivot+1,right);
        }
    }
    //经过一轮排序找到这个值所在的位置
    /**
     * 法一
     *
     */
    static public int getPartition(int[] ints,int partition,int right){
        int index = partition+1;
        for (int i = index; i <= right; i++) {
            if (ints[i]<ints[partition]){
                swap(ints,index,i);
                index++;
            }
        }
        swap(ints,partition,index-1);
        return index-1;
    }

    /**
     * 法二
     * @param ints 数组
     * @param left 基准值
     * @param right 右边界
     * @return
     */
    static public int getPartition2(int[] ints,int left,int right){
        int pivot = left;
        while (left<right){
            int num = ints[left];
            while (ints[right] > num && right>left){
                right--;
            }
            while (num >= ints[left] && left<right){
                left++;
            }
            if (left == right){
                break;
            }
            swap(ints,left,right);
        }
        //交换标准值
        swap(ints,pivot,left);
        return left;
    }

    static public int[] swap(int[] ints,int i,int j){
        int num = ints[i];
        ints[i] = ints[j];
        ints[j] = num;
        return ints;
    }



}
