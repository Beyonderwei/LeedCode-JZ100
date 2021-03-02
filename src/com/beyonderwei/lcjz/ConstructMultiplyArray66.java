package com.beyonderwei.lcjz;

/*
 1. 题解：通过计算上三角和下三角的乘积，只需两次循环，直接即可计算出所有的结果，注意下标位置和循环边界

 2. 参考：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
*/


public class ConstructMultiplyArray66 {

    public int[] constructArr(int[] a) {
        if(a.length == 0) return new int[0];
        int[] res = new int[a.length];
        int tmp = 1; // tmp 保存上三角，从后往前n个元素的乘积
        res[0] = 1; // 初始化第一个下三角元素
        // 循环计算下三角每行乘积，保存在res[i]中
        for(int i = 1; i < a.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        // 将上三角的乘积 tmp  直接乘到下三角（res【i】）的乘积中
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}
