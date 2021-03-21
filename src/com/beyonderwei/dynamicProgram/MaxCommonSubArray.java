package com.beyonderwei.dynamicProgram;

/**
 * 求两个字符串的最长公共子序列
 * 二维 dp的动态规划问题
 * dp[i][j] : s1 的前i个
 */

public class MaxCommonSubArray {

    private static int[][] dp;

    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "111facdfg";
        int m = str1.length();
        int n = str2.length();
        dp = new int[str1.length()][str2.length()];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(recure(str1, 0, str2, 0));
    }


    // 动态规划找到最长子序列
    public static int recure(String str1, int i, String str2, int j) {
        if(i == str1.length() || j == str2.length()) return 0;
        // 去dp中找到子问题，避免重复计算
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j)) dp[i][j] = 1 + recure(str1, i + 1, str2, j + 1);
        else {
            dp[i][j] = Math.max(
                    recure(str1, i, str2, j + 1),
                    recure(str1, i + 1, str2, j)
            );
        }
        return dp[i][j];
    }

}
