package com.algorithms.leetCode.JZ;

public class JZ11 {

    public int minArray(int[] numbers) {
        if (numbers == null){
            return -1;
        }
        int start = numbers[0];
        for (int i=1;i<numbers.length;i++){
            if (numbers[i]<start){
                return numbers[i];
            }
        }
        return start;

    }

}
