package com.beyonderwei.lcjz;


/*
 1. 题解：
        直接记住：以长度3等分时乘积最大
        参考：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
*/
public class CutRope14A {

    public int cuttingRope(int n) {
        if(n <= 3) return n - 1; // 小于3返回 n-1
        int a = n / 3, b = n % 3; // a为长度为3的个数 b为余数
        if(b == 0) return (int)Math.pow(3, a); // 1. b=0 直接返回3^a
        if(b == 1) return (int)Math.pow(3, a - 1) * 4; // 2. b=1 因为 2*2 > 3*1  返回3^(a-1) * 4
        return (int)Math.pow(3, a) * 2; // 3. b=2 返回 3^a * 2
    }

}
