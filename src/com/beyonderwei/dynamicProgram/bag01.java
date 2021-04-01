package com.beyonderwei.dynamicProgram;

import java.util.Arrays;

/**
 * 0 1 背包问题，将背包 物品数量N  背包容量W  每个物品重量int[] wt, 每个物品价值 int[] val 求背包能装的最大价值
 *
 */

public class bag01 {
    private static int N = 10, W = 20; // N 物品数   W 背包容量
    private static int[][] dp = new int[N][W];
    int maxvalue(int W, int N, int[] wt, int[] val) { // wt: 每个物品的重量  val: 每个物品的价值
        // dp 全填入 0
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i-1] < 0) {
                    // 当前背包容量装不下，只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i-1]] + val[i-1],
                            dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }
}
