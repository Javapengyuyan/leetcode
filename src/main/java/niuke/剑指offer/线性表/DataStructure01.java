package niuke.剑指offer.线性表;

import java.util.List;

public class DataStructure01 {

    /**
     * 02将顺序表的所有元素逆置，要求空间复杂度为O(1)
     *
     * 解：因为对空间有限制，所以不能new新的队列、栈
     * 两个位置相互对调即可
     */
    public List exchange(List list){
        if (list == null)return list;
        Object object;
        for (int i=0;i<list.size()/2;i++){
            object = list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,object);
        }
        return list;
    }

    /**
     *
     */

}
