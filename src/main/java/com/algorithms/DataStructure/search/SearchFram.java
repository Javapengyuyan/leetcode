package com.algorithms.DataStructure.search;

import java.util.List;

/**
 * @author: long
 * @create: 2022-03-22 23:23
 * @Description 查找框架
 *
 * 分类：1、线性结构  方式：顺序查找、折半查找、分块查找
 *      2、树形结构  方式：二叉排序树、二叉平衡树、B树、B+树
 *      3、散列结构  方式：散列表（性能分析、冲突处理）
 *
 *  指标：平均查找长度--ASL
 *
 **/

public class SearchFram {

    /**
     * 6.2.1、顺序查找
     * 注意：引入哨兵机制，使用key来代替判断操作，提高效率。
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "ababcd";
        String s2 = "cbda";
        //int i = testKMP(s1, s2);
        char[] chars = s1.toCharArray();
        //GetNext(chars,new int[s1.length()]);

    }

    /**
     * 6.2.2、折半查找
     * 注意：仅适用于有序的顺序表。
     * @param list 集合、数组
     * @param key 查找的key
     */
    public Integer binarySearch(List<Integer> list ,int key){
        int left = 0;
        int right = list.size()-1;
        while (left<=right){
            Integer mid = (left + right) / 2;
            Integer midNum = list.get(mid);
            if (midNum == key){
                return mid;
            }else if (midNum > key){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    /**
     * 6.3、B树、B+树查找
     * 树的高度
     */

    /**
     * 6.4、散列（hash）表
     * 散列函数：把关键字映射成对应地址的函数
     *   构造方法：1、直接定址法。2、除留余数法。3、数字分析法。4、平方取中法。5、折叠法。
     *   冲突解决方法：1、开放定址法。1）线性探测。2）平方探测。3）再散列。
     *               2、拉链法。
     * 散列表：映射后的散列存储关系表。
     *
     */

    /**
     * 找最长公共前后缀。
     *
     * 法一、直接用string带的方法进行判断。
     * int i = str.indexOf(pattner);
     * 法二、每个循环判断
     * 法三、
     * 6.5、KMP算法
     * 比较指针不用回溯
     *
     */



}
