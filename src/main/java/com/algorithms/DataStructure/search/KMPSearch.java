package com.algorithms.DataStructure.search;

import java.util.Arrays;

/**
 * @author: long
 * @create: 2022-03-27 16:24
 * @Description 字符串查找中的KMP算法
 *          1、计算每个字符最长前后缀
 *          2、模式串匹配
 **/

public class KMPSearch {

    public static void main(String[] args) {
        String str = "abcabcababcdabcd";
        String stPattern = "ababcd";
        int[] ints = new int[stPattern.length()];
        next(stPattern.toCharArray(),ints);
        int search = search(str.toCharArray(), stPattern.toCharArray(), ints);
        System.out.println(search);
    }

    //前后：A=B+C，则B是A的前缀，A=C+B，B是A的后缀。
    static public int search(char[] str,char[] pattern,int[] ints){
        int i = 0,j=0;
        while (i<str.length && j<pattern.length){
            if (j==-1 || str[i] == pattern[j]){
                ++i;++j;
            }else {
                //注意这里的赋值
                j=ints[j];
            }
        }
        if (j == pattern.length){
            return i-j;
        }
        return -1;
    }

    /**
     * 重点：每次比较的位置=最长公共前缀长度+1
     * 计算模式串的next[]数组
     * 推论过程：
     * https://www.bilibili.com/video/BV16X4y137qw/?spm_id_from=333.788.recommend_more_video.-1
     * @param chars 模式串
     * @return
     */
    static public void next(char[] chars,int[] ints){
        ints[0] = -1;
        int i=0,j=-1;
        while (i<chars.length -1){
            if (j==-1){
                i++;j++;
            }else if (chars[i] == chars[j]){
                ints[++i] = ++j;
            }else {
                j = ints[j];
            }
        }
    }

    //两个next方法一样
    public static void getNext(char[] pattern,int[] next){
        next[0] = -1;
        int i =0,j=-1;
        /**
         * 看门牌算法，后面查看前面k依次往前递推，next[j+1]可能最大值为next[next[j+1]]+1
         * 这里注意while判断条件，如果是pattern.length，
         * 如果后两个都相同会出现下标越界。
         */
        while (i<pattern.length-1){
            if (j==-1){
                i++;j++;
            }else if (pattern[i] ==pattern[j]){
                ++i;++j;
                next[i] = j;
            }else {
                j = next[j];
            }
        }

    }



}
