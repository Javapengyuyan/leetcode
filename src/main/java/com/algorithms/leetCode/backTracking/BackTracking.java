package com.algorithms.leetCode.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTracking {

    public static void main(String[] args) {
        int[] ints = new int[]{1,0,2};
        backTrack(new LinkedList(),ints);
        System.out.println(result);
    }

    /**
     * 全排列
     * @return
     */
    static List<List<Integer>> result = new ArrayList<>();

    static public void backTrack(LinkedList list, int[] ints){
        //传入选择集合、路径，根据路径长度进行处理
        if (list.size() == ints.length){
            //每次添加结果时候新创建对象，否则添加的都是原来new的linkedList，是个空值
            result.add(new LinkedList<>(list));
            return;
        }
        //为循环递归调用，一层套一层，内层循环完之后跳出再循环外层（进行回退）
        for (int i=0;i<ints.length;i++){
            if (list.contains(ints[i])){
                continue;
            }
            list.add(ints[i]);
            backTrack(list,ints);
            list.removeLast();
        }
    }

    //n皇后


}
