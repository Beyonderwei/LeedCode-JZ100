package com.beyonderwei.lcjz;

import java.util.ArrayList;
import java.util.List;


/*
 1. 题解：滑动窗口的方法解题，左右窗口边界只能从左向右滑动，不断寻找符合条件的结果，不满足要求即调整窗口

 2. 参考：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/

*/


public class FindCertainSumSequence57_2 {

    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 0;
        List<int[]> res = new ArrayList<>();
        while(left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++; // 右窗口向左滑动
            } else if (sum > target) {
                sum -= left;
                left++; // 左窗口向右滑动
            } else {
                int[] tmp = new int[right - left];
                for (int i = left; i < right; i++) {
                    tmp[i-left] = i;
                }
                res.add(tmp);
                sum -= left;
                left++; // 左窗口向右滑动,继续寻找还有没有解
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
