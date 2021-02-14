package com.beyonderwei.lcjz;


/*
 1. 思路：快速幂法，二分法，将x不断的变为 x^2 来减小计算次数（时间复杂度O(log n)） 如：X=x^2 奇数时将最后一个x乘到res中
        x * x * x * x * x
          X   *   X  * res
        最后 b一定为1  然后结果会保存在res中，因此可直接返回。

 2. 参考：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
*/
public class MathPow16 {
    public double myPow(double x, int n) {
        // 1. 特殊情况1
        if (x == 0) {
            return 0;
        }
        // 2. 特殊情况2  防止越界（正负转换时）
        long b = n;
        // 3. 特殊情况3 如果是负幂次，需要转为正幂次，然后x为 1/x
        if (b < 0) {
            x /= 1;
            b = -b;
        }
        double res = 1;
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>>= 1;
        }
        return res;
    }
}
