package com.beyonderwei.lcjz;


/*
 1. 题解：
        直接由10的n次方得到n位数的最大值+1，减一得到最大三位数，for循环将数值放到数组中返回
        注意：存值的时候要将i + 1存入，不然会从0开始，而题目要求从1开始
*/
public class BigNumPrint17 {
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10, n);
        int res[] = new int[max - 1];
        for (int i = 0; i < max - 1; i++) {
            res[i] = i + 1; // 注意点
        }
        return res;
    }
}
