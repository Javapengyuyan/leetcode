package leetCode.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTracking {

    public static void main(String[] args) {
        int[] ints = new int[]{1,0};
        backTrack(new LinkedList(),ints);
        System.out.println(reslut);
    }

    /**
     * 全排列
     * @return
     */
    static List<List<Integer>> reslut = new ArrayList<>();

    static public void backTrack(LinkedList list, int[] ints){
        if (list.size() == ints.length){
            reslut.add(new LinkedList<>(list));
            return;
        }
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
