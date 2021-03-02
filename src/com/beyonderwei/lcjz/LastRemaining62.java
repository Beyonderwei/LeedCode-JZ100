package com.beyonderwei.lcjz;

/*
 1. 题解：动态规划方式，主要是状态转移方程的推导，res = (res + m) % i

 2. 参考：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/jian-zhi-offer-62-yuan-quan-zhong-zui-ho-dcow/
*/

public class LastRemaining62 {

    public int lastRemaining(int n, int m) {
        int res = 0; // dp[1] 为 0
        // 从dp[2]开始，到dp[n] 包括n，表示有几个数字
        for(int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

}
