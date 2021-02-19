package com.beyonderwei.lcjz;

/*
 1. 题解：动态规划的方法，状态为以下标i，结尾的所有子串的最大值，状态转移方程如下
        - dp[i-1] > 0  dp[i] = dp[i-1] + nums[i]
        - dp[i-1] < 0  dp[i] = nums[i]

 2. 注意：通过维护最大值，节省dp数组，使空间复杂度为 O(1)

 3. 参考：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
*/

public class MaxSubArray42 {

    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0]; // 最大值
        int pre_max = max; // for循环中，i-1为结尾的最大值
        for(int i = 1; i < nums.length; i++) {
            if (pre_max > 0) { // pre_max > 0 代表以i结尾子数组最大值为 pre_max + nums[i];
                pre_max = pre_max + nums[i];
            } else { // pre_max < 0 代表以i结尾子数组最大值为 nums[i];
                pre_max = nums[i];
            }
            max = max > pre_max ? max : pre_max;
        }
        return max;
    }
}
