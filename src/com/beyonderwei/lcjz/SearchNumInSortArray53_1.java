package com.beyonderwei.lcjz;


/*
 1. 题解：通过二分查找，找到与目标值相等的值，没有直接返回0  有的话则在该值左右寻找该值的个数

 2. 参考：相比于Leedcode解法能少一次二分查找

*/

public class SearchNumInSortArray53_1 {

    public int search(int[] nums, int target) {
        int res = 0, targetIndex = 0;
        int left = 0, right = nums.length - 1;
        // 二分查找
        while(left <= right) {
            int cur = (left + right) / 2;
            if (nums[cur] < target) left = cur + 1;
            else if (nums[cur] > target) right = cur - 1;
            // 有相等的值 直接跳出，此时满足 left <= right
            else {
                targetIndex = cur;
                break;
            }
        }
        // 这个值存在
        if(left <= right) {
            res = 1;
            int targetIndexCopy = targetIndex;
            // 向右寻找这个值相等的值
            while(++targetIndex <= (nums.length - 1) && nums[targetIndex] == target) {
                res++;
            }
            // 向左寻找相等的值
            while(--targetIndexCopy >= 0 && nums[targetIndexCopy] == target) {
                res++;
            }
            return res;
        } else {
            return res;
        }
    }
}
