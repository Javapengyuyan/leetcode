package com.algorithms.leetCode.Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: long
 * @create: 2022-04-13 20:59
 * @Description
 **/

public class Hot22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
        int leftNum = 0;
        int rightNum = 0;
        backTrackParen(result,new StringBuffer(),leftNum,rightNum,n);
        System.out.println( result.toString() );
    }

    static void backTrackParen(List<String> list,StringBuffer cur,int leftNum,int rightNum,int n){
        if (cur.length() == 2*n){
            list.add(cur.toString());
            return;
        }

        if (leftNum < n){
            cur.append("(");
            //回溯
            /**
             * 这里要注意，leftNum和rightNum在回溯时候不能用++，不然会导致数值变化产生不正确的判断。
             */
            backTrackParen(list,cur,leftNum+1,rightNum,n);
            cur.deleteCharAt(cur.length()-1);
        }
        if (rightNum < leftNum){
            cur.append(")");
            backTrackParen(list,cur,leftNum,rightNum+1,n);
            //撤销选择
            cur.deleteCharAt(cur.length()-1);
        }

    }

}
