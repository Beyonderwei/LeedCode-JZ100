package com.beyonderwei.lcjz;

/*
 1. 题解：通过二分查找，找到缺失值附近的值，然后左右对比，判断是否递增，不递增则直接返回缺失值

*/


public class MissingNumberInSortArray53_2 {

    public int missingNumber(int[] nums) {
        // 处理第一个0缺失的情况
        if(nums[0] != 0) return 0;
        int left = 0, right = nums.length - 1;
        // 二分遍历 退出时  left = right
        while(left < right) {
            int cur = (left + right) / 2;
            if(nums[cur] <= cur) left = cur + 1; // nums[cur] <= cur 说明缺失值在右侧，否则在左侧
            else right = cur -1;
        }
        // 避免后面处理时下标越界，对该情况单独处理
        if(left == 0) {
            return nums[left] == left ? 1 : 0;
        }
        if (nums[left - 1] != nums[left] - 1) return nums[left] - 1;
        else return nums[left] + 1;
    }

}
