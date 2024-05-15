package com.algorithms.leetCode.JZ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: long
 * @create: 2023-02-18 22:18
 * @Description
 **/

public class JZ60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        float[] result = new float[5*n+1];
        float totalType = 6 ^ n;

    }





    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
