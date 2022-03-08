package com.personal.leetcode.Test;

public class TestCode {
    //10 -1 0 -2 3 7 4

    //-2 3
    //0 3
    //10 *

    //8 5 5 3 2
    //2
    public Integer findNum(Integer num){
        int[] ints = {};
        if (!(ints.length >0)){
            return null;
        }
        int start = 0;
        int end = ints.length-1;
        int mid =0;
        for (int i=0;i<ints.length/2;i++){
            mid = (start+end)/2;
            if (ints[start]>num){
                start = mid;
            }else if (ints[end]<num){
                end = mid;
            }
        }
        return ints[mid];

    }




}
