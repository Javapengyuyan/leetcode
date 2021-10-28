package leetCode.dynamicProgramming;

public class JZ63 {
    /**
     * 第一步：动态规划写出状态转移方程，找到等式点，如：
     * 最高收益=max(昨日前最高收益,当日可得收益)
     * 当日收益=当日价格-历史最低价格
     * 寻找一个中间变量保留历史最低价、最大收益
     * 只用一次循环
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {7,1,5,3,6,4};
        System.out.println(maxProfit(ints));

    }

    static public int maxProfit(int[] profits){
        int profit = 0,cost = Integer.MAX_VALUE;
        for (int i : profits) {
            cost = Math.min(cost,i);
            profit = Math.max(profit,i-cost);

        }
        return profit;
    }

}
