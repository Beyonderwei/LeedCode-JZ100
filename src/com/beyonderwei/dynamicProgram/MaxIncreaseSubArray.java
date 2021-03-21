package com.beyonderwei.dynamicProgram;


/**
 * 求某个数组的最最长递增子序列 [-2, 1, 3, -3, 4, -1, 2, 3, 5, 1, -5, 4]  最长为连续4个    :  -1, 2, 3, 5
 * 一维dp的动态规划问题
 * dp[i] 含义为以arr[i] 为结尾的最长子序列大小
 */

public class MaxIncreaseSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, 3, -3, 4, -1, 2, 3, 5, 1, -5, 4};
        System.out.println(maxIncrease(arr));
    }

    // 减小空间复杂度的形式
    public static int maxIncrease(int[] arr) {
        int res = 1;
        int dpi_1 = 1;
        int dpi;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) dpi = dpi_1 + 1;
            else dpi = 1;
            dpi_1 = dpi;
            res = Math.max(res, dpi);
        }
        return res;
    }
}
