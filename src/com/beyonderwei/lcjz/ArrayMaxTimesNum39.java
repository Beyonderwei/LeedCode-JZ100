package com.beyonderwei.lcjz;

/*
 1. 题解：投票的方式，遍历数组，cur一直被认为是出现最多次数的值，相等投票数就增加，不相等就减少，等于零表明后面出现最多的也是整个数组出现最多的
         还有hash表统计，排序取中间值的方法
 2. 参考：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
*/

public class ArrayMaxTimesNum39 {

    public int majorityElement(int[] nums) {
        // 初始化，也可以初始化为0，然后数组从下标0开始遍历
        int cur = nums[0];
        int vote = 1;
        for(int i = 1; i < nums.length; i++) {
            if(vote == 0) cur = nums[i]; // 等于0，认定当前值就是出现最多的数
            if(nums[i] != cur) vote--; // 不相等  票数减少
            else vote++; // 相等 票数增加
        }
        return cur;
    }
}
