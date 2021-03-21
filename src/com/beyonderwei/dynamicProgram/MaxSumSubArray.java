package com.beyonderwei.dynamicProgram;


/**
 * 求某个数组的最大连续子数组的和，数组包括正负数如[-2, 1, -3, 4, -1, 2, 1, -5, 4]  最大为 6 = 4 - 1 + 2 + 1
 * 一维dp的动态规划问题
 * dp[i] 含义为以arr[i] 为结尾的最大子数组和
 */

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSum(arr));
    }

    // 减小空间复杂度的形式
    public static int maxSum(int[] arr) {
        int res = arr[0];
        int dpi_1 = arr[0], dpi = arr[0]; // dpi_1 存放的是 dp[i - 1]   dpi 存放的是dp[i]
        for (int i = 1; i < arr.length; i++) {
            dpi = Math.max(arr[i], arr[i] + dpi_1);
            dpi_1 = dpi;
            res = Math.max(res, dpi);
        }
        return res;
    }

    // 直接采用 dp数组的形式
    /*public static int maxSum(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
        }
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/
}
