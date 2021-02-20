package com.beyonderwei.lcjz;


/*
 1. 题解：主要在于找规律，
         - 一位数：1-9  有九个字符
         - 二位数：10-99 有 9 * 2 * 10 个
         - 三位数：100-999  有9 * 3 * 100个

 2. 参考：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
*/

public class FindNthDigit44 {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9;
        while(n > count) {
            n -= count;
            start *= 10; // 1 10 100
            digit ++; // 1 2 3 4
            count = 9 * digit * start; // 1-9有9个   10-99 有180个
        }
        long num = start + (n - 1) / digit; // 因为第一个数start，除去最高位为0，而n是从1开始计数，因此为得到这个数需要 n - 1
        int num_pos = (n - 1) % digit;
        return Long.toString(num).charAt(num_pos) - '0'; // 字符相减，减去字符0即表示该数字是几
    }
}
