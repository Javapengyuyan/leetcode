package GraphAlgorithm.ChapterFour;

import java.util.Arrays;

public class DivideAndConquer {

    /**
     * 分治方法
     */

    public static void main(String[] args) {

        //System.out.println(sum(3));
        int[] ints = new int[]{1,3,5,4,6,9,7,2};
        int[] test = list(ints);
        System.out.println(test);
    }


    //4.1 递归方法sum
    public static Integer sum(Integer i){
        if (i == 0){
            return i;
        }else {
            return i + sum(i-1);
        }
    }

    public static int[] list(int[] ints){
        if (ints == null){
            return null;
        }
        if (ints.length == 1){
            return ints;
        }else {
            ints[ints.length-2] = ints[ints.length-2] + ints[ints.length-1];
            return list(Arrays.copyOf(ints,ints.length-1));
        }

    }

    //函数式编程



    //4.3 找出列表中最大的数字






}
