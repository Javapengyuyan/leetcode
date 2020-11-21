package DataStructure;

import niuke.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class DataStructure01 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(9);
        list.add(17);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(6);
        list2.add(6);
        list2.add(9);
        list2.add(11);
        System.out.println(getMid(list,list2));

    }

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
     * 05 从顺序表中删除其值在给定值s,t之间的所有元素（s<t）不合理返回null
     *
     * 解：顺序表，移除特定数值，其它位置上的值往前移
     */
    public ListNode remove(ListNode listNode, int s, int t){
        if (t<s || listNode == null )return null;
        int k = 0;
        while (listNode.next != null){
            //剔除listnode节点，并按指定
            if (listNode.val>s && listNode.val <t){
                k++;
                listNode = listNode.next;
            }
        }
        return listNode;
    }

    public List remove(List<Integer> list,int s,int t){
        if (t<s || list.size() < 1 )return null;
        int k = 0;
        for (int i = 0;i<list.size();i++){
            Integer integer = list.get(i);
            if (integer > s && integer < t){
                k++;
                if (list.size()>= (k+i-1)){
                    list.set(k,list.get(k+i-1));
                }
            }

        }
        return list;
    }

    /**
     * 06从有序顺序表中删除所有重复值
     */

    /**
     * 07 将两个有序顺序表合并成一个
     */


    /**
     * 08一维数组中依次存放着两个线性表(a1.a2.a...an)和(b1.b2...bm)，将两个数组互换
     *
     * 解：类似于矩阵求逆矩阵，然后依次单独求逆矩阵
     */
    public static int[] exchange(int[] exchange ,int n,int m){
        if (exchange == null)return null;
        for (int i =0;i<exchange.length/2;i++){
            int a = exchange[i];
            exchange[i] = exchange[exchange.length-i-1];
            exchange[exchange.length-i-1] = a;
        }
        //分别交换m/n
        for (int i=0;i<m/2;i++){
            int a = exchange[i];
            exchange[i] = exchange[m-i-1];
            exchange[m-i-1] = a;
        }
        for (int i=0;i<n/2;i++){
            int a = exchange[i+m];
            exchange[i+m] = exchange[exchange.length-i-1];
            exchange[exchange.length-i-1] = a;
        }
        return exchange;
    }

    /**
     * 10 将n个数组放到数组堆R中，将R中保存的序列循环左移p个
     *
     * 解：相当于ab求ba。先求a逆序，再求b逆序，最后ab逆序
     */

    /**
     * 11 长度为L的升序序列S，取中位数，现有两个等长序列，求两个序列的中位数
     *
     * 解：① 有序则依次获取，到第n个
     *
     * 解：② 分别获取L1和L2的两个中位数，比较，舍去大的那组大的数，小的那组小的
     *  然后依次获取，直到剩一个为止。
     */
    public static int getMid(List<Integer> l1,List<Integer> l2){
        int mid = 0;
        int length = l1.size();
        int l1num = 0;
        int l2num = 0;
        for (int i=0;i<length;i++){
            if (l2.get(l2num)<l1.get(l1num)){
                mid = l2.get(l2num);
                l2num++;
            }else {
                mid = l1.get(l1num);
                l1num++;
            }
        }
        return mid;
    }

    /**
     * 12 一个整数数组，存在一个数字超过数组个数的一半，则称为主元素，否则输出-1，输出主元素
     *
     * 解：选取c记录数初始值记录1个，遇到相同+1，不同-1.为0换下一个数
     */


}
