package com.beyonderwei.lcjz;

/*
 1. 题解：上下左右四个边界，每次遍历完一行或者一列之后，内缩边界，并判断是否结束，结束直接break；

 2. 参考：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
*/

public class PrintMatrix29 {

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0]; // 数组为空时直接返回空数组
        int index = 0; // 要返回的数组
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int left = 0, right = n - 1, top = 0, bottom = m -1; // 得到上下左右边界
        while(true) {
            for(int i = left; i <= right; i++) res[index++] = matrix[top][i]; // 从左向右遍历，结束后top++
            if(++top > bottom) break; // 退出条件

            for(int i = top; i <= bottom; i++) res[index++] = matrix[i][right]; // 从上到下
            if(--right < left) break;

            for(int i = right; i >= left; i--) res[index++] = matrix[bottom][i]; // 从右向左
            if(--bottom < top) break;

            for(int i = bottom; i >= top; i--) res[index++] = matrix[i][left]; // 从下往上
            if(++left > right) break;
        }
        return res;
    }
}
