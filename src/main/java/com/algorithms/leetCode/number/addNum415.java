package com.algorithms.leetCode.number;

import java.util.HashMap;
import java.util.Map;

public class addNum415 {

    /**
     * char类型直接转int数值不对，但是在ASCII码表中和0的距离之差是对应数字。
     * @param args
     */
    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        int x = 8;
        x = x>>1;
        int[] ints = {30000,500,100,30000,100,30000,100};
        System.out.println(singleNumber(ints));
        //int i = num1.charAt(2)-'0';
        //System.out.println(addStrings(num1,num2));

    }

    static public String addStrings(String num1, String num2) {
        int m = num1.length()-1;
        int n = num2.length()-1;
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ( m>=0 || n >=0 ){
            int x = m<0?0:num1.charAt(m)-'0';
            int y = n<0?0:num2.charAt(n)-'0';
            int last = (x + y + sum)%10;
            stringBuilder.append(last);
            sum = (x + y + sum)/10;
            m--;n--;
        }
        if (sum != 0){
            stringBuilder.append(sum);
        }
        return stringBuilder.reverse().toString();
    }

    /**
     * 数字二进制中的1的个数
     * @param n
     * @return
     */
    static public int[] countBits(int n) {
        int[] ints = new int[n+1];
        //ints[0] = 0;
        //ints[1] = 1;
        for (int i=0;i<=n;i++){
            if (i%2 == 0){
                ints[i] = ints[i>>1];
            }else {
                ints[i] = ints[i-1]+1;
            }

        }
        return ints;
    }

    /**
     * 04
     * 某个元素只出现一次，其余均出现3次
     * @param nums
     * @return
     */
    static public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i=0;i<nums.length;i++){
            int num = nums[i];
            Integer times = hashMap.get(num);
            if (times == null ){
                hashMap.put(num,1);
            }else {
                //times++;
                hashMap.put(num,++times);
            }
        }
        int reslut =-1;
        for (Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
            if (entry.getValue() == 1){
                reslut = entry.getKey();
            }
        }
        return reslut;
    }

    /**
     * for (int num : nums) {
     *                 cnt += num >> i & 1;
     *             }???
     *
     */


}
