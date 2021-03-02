package com.beyonderwei.lcjz;

/*
 1. 题解：由于不能使用乘法、循环、判断等，因此需要使用 & | 等作为截止条件，通过递归计算的话，直接将n>1作为截止条件，当n等于1的时候，直接会返回1

 2. 参考：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
*/


public class SumNums64 {

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
