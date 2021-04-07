package com.beyonderwei.leetcode;

import java.util.*;

/**
 * 判断数组中是否有两数之和为0，
 * 一次遍历就可以完成：每次从map中获取 target - nums[i] 获取不到就将这个值加到map中，获取得到直接返回下标
 * map 中存储key: nums[i] value：下标
 */


public class TwoNumSum1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] res;
        res = twoSum(nums, 9);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int  i = 0; i < n; i++) {
            if(map.get(target - nums[i]) != null) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
