package com.beyonderwei.leetcode;

import java.util.*;

/**
 * 求数组中所有和为 0 的三元组
 * 注意：
 * 1. while循环，先判断 j 是否大于 i
 * 2.
 */

public class ThreeNumSum15 {

    private static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        threeSum(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return new LinkedList<>();
        Arrays.sort(nums);
        for (int k = 0; k < n - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = n - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    LinkedList<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[k]);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    res.add(new LinkedList<>(tmp));
                    while(j > i && nums[j] == nums[j - 1]) {
                        j -= 1;
                    }
                    j -= 1;
                    while(j > i && nums[i] == nums[i + 1]) {
                        i += 1;
                    }
                    i += 1;
                }
                else if(sum > 0) {
                    while(j > i &&nums[j] == nums[j - 1]) {
                        j -= 1;
                    }
                    j -= 1;
                }else {
                    while(j > i && nums[i] == nums[i + 1]) {
                        i += 1;
                    }
                    i += 1;
                }
            }
        }
        return res;
    }

}
