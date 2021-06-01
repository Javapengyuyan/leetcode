package GraphAlgorithm.ChapterTwo;

public class SelecionSort {

    /**
     * 选择排序
     * 一串无序数组排序，循环遍历每次找出最小的和最前面交换
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = new int[]{1,3,5,4,6,9,7,2};
        //外层循环控制个数
        for (int i=0;i<ints.length;i++){
            //内层循环查找最小值交换
            int swit;
            for (int j = i+1;j<ints.length;j++){
                if (ints[j]<ints[i]){
                    swit = ints[j];
                    ints[j]= ints[i];
                    ints[i]= swit;
                }
            }
        }
        System.out.println(ints);
    }

    /**
     * 注意：循环条件判定临界值
     * 时间复杂度O(n²)
     */


}
