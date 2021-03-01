package com.beyonderwei.lcjz;

/*
 1. 题解：头尾两个指针向中间合并，如果相遇直接返回，比目标值大，右指针左移，反之右移，证明参考题解

 2. 参考：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/

*/


public class TwoSumInSortArray57 {

    public int[] twoSum(int[] nums, int target) {
        int pre = 0, last = nums.length - 1;
        while(pre < last) {
            if(nums[pre] + nums[last] == target) return new int[] {nums[pre], nums[last]};
            if(nums[pre] + nums[last] > target) last--;
            else pre++;
        }
        return new int[0];
    }
}
