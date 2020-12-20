package algorithm.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] ints = new int[]{3,5,1,8,2};
        //ints = sort(ints);
        ints = leftSort(ints);
        System.out.println(ints);
    }


    /**
     * 从左往右冒泡
     * @param ints
     * @return
     */
    public static int[] sort(int[] ints){
        if (ints.length<2){
            return ints;
        }
        for (int i=0;i<ints.length;i++){
            for (int j= 0;j<ints.length-i-1;j++){
                if (ints[j]<ints[j+1]){
                    ints[j] = ints[j]+ints[j+1];
                    ints[j+1] = ints[j]-ints[j+1];
                    ints[j] = ints[j]-ints[j+1];
                }
            }
        }
        return ints;
    }

    /**
     * 从右往左冒
     * @param ints
     * @return
     */
    public static int[] leftSort(int[] ints){
        if (ints.length<2) return ints;
        for (int i=0;i<ints.length;i++){
            for (int j=ints.length-1;j>i;j--){
                if (ints[j]>ints[j-1]){
                    ints[j] = ints[j]+ints[j-1];
                    ints[j-1] = ints[j]-ints[j-1];
                    ints[j] = ints[j]-ints[j-1];
                }
            }

        }
        return ints;
    }



}
