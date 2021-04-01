package com.beyonderwei.dynamicProgram;

import java.util.Arrays;

/**
 * 给定两个字符串，计算由str1 编辑得到 str2 所需的最小编辑次数（可增、删、改）
 * dp[i][j] 表示 s1[..i] 转换为 s2[..j] 的最小编辑次数
 * 重要理解方式： 初始化后，表的第一行和第一列是固定的，两个for循环依次往后计算，      ** 观察 DP表 **
 *  - 如果 i j 处的字符相等：某个位置的值 = 该位置左上角的值
 *  - 如果 i j 处的字符不相等：某个位置的值 = 该位置左上角的值、左边、和上边的值中小的那个加一
 */


public class MinEditDistance {

    static int[][] dp;
    public static void main(String[] args) {
        String s1 = "xuwei";
        String s2 = "xialian";
        System.out.println(minDistance(s1, s2));
    }

    public static int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1, // s1 插入一个与s2[j]相等的字符
                            dp[i][j - 1] + 1, // s2 删除一个字符
                            dp[i - 1][j - 1] + 1 // 替换一个字符
                    );
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
