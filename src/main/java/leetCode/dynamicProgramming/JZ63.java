package leetCode.dynamicProgramming;

public class JZ63 {

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
