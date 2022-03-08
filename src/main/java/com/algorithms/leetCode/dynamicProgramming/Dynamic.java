package com.algorithms.leetCode.dynamicProgramming;

import java.util.Arrays;

public class Dynamic {
    /**
     * 动态规划：
     * 是求最值的问题，可以通过穷举来对比，
     * 因为有选择所以状态会变，添加特殊判断
     * 通过添加备忘录来减少重复计算
     *
     */
    //爬楼梯 f(n)=f(n-1)+f(n-2)
    static int sum = 0;
    static public int plt(int num){
        if (num <=2){
            return num;
        }
        return plt(num-1)+plt(num-2);

    }
    //非递归方式
    public int climb(int n){
        int x=0,y=0,sum =1;
        for (int i=0;i<=n;i++){
            x=y;
            y = sum;
            sum = x+y;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] ints = {2};
        //System.out.println(plt(5));
        System.out.println(coinChange(ints,3));
    }

    /**
     * 322、零钱兑换
     * @param coins 硬币种类
     * @param amount 总金额
     * @return
     */
    static public int coinChange(int[] coins, int amount) {
        int[] ints = new int[amount+1];//dp数组
        Arrays.fill(ints,amount+1);//取一个比较大的特殊数组值，大于amount用来记录
        ints[0] = 0;
        //循环所有金额
        for (int i=1;i<amount+1;i++){
            //循环所有硬币
            for (int j=0;j<coins.length;j++){
                //无法获取跳过
                if (i<coins[j]){
                    continue;
                }
                //状态转移方程
                ints[i] = Integer.min(ints[i],ints[i-coins[j]]+1);
            }
        }
        //特殊情况 是否能凑出金额
        return ints[amount]>amount?-1:ints[amount];

    }

}
