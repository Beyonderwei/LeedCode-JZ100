package com.beyonderwei.lcjz;

/*
 1. 思路：n & 1 结果为1表示最后一位为1，为0表示最后一位为0 直到n为0

 2. 参考：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
        有更巧妙的 n&(n-1) 方式，可降低时间复杂度
*/

public class HammingWeight15 {
    public int hammingWeight(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n & 1; // 结果为1表示最后一位为1，为0表示最后一位为0
            n >>>= 1; // 右移一位
        }
        return sum;
    }
}
