package GraphAlgorithm.ChapterFour;

import java.util.Random;

public class QuickSort {

    /**
     * 使用快速排序，将数组从低到高排序
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {8,3,6,2,5,1,9};
        //随机选择一个主元
        Random random = new Random();
        Integer x = random.nextInt(ints.length -1);
        int i=0,j=ints.length-1;
        while (i>=j){
            if (ints[i]>ints[x]){
                swap(ints,i,x);
            }
            i++;
            if (ints[j]<ints[x]){
                swap(ints,j,x);
            }
            j--;

        }


    }

    public static void swap(int[] ints,int i,int j){
        int x = ints[i];
        ints[i] = ints[j];
        ints[j] = x;
    }


}
