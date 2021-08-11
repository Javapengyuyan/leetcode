package leetCode.easy;

public class Sort {
    /**
     * 排序算法
     */
    public static void main(String[] args) {
        int[] ints = {3,5,1,9,7,2,8};
        System.out.println(ints);
        System.out.println(insertSort(ints));

    }

    /**
     * 插入排序:直接插入、折半插入
     * 时间复杂度，空间复杂度
     *  80万个数据总共耗时：直接插入2分零8秒,冒泡10+分钟
     */
     static public int[] insertSort(int[] ints){

        for (int i=1;i<ints.length;i++){
            int j= i;
            //找到一个比int[j]大的
            while ( j>0 ){
                if (ints[j]<ints[j-1]){
                    swap(ints,j,j-1);
                    j--;
                }else {
                    break;
                }
            }
        }
        return ints;
    }

    static public int[] swap(int[] ints,int i,int j){
        int num = ints[i];
        ints[i] = ints[j];
        ints[j] = num;
        return ints;
    }


    /**
     * 交换排序:冒泡、快排
     * 时间复杂度，空间复杂度
     */



    /**
     * 选择排序:简单选择、堆选择
     * 时间复杂度，空间复杂度
     */

    /**
     * 归并排序:时间复杂度，空间复杂度
     */


}
