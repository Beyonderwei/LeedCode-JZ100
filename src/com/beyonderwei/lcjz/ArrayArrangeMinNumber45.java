package com.beyonderwei.lcjz;

import java.util.Arrays;

/*
 1. 题解：实际上还是对字符串数组进行排序，比较的每个单元为 strs[i] 的大小， 暂时使用内置的排序算法，


 2. 参考：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
*/


public class ArrayArrangeMinNumber45 {

    public String minNumber(int[] nums) {
        // 将数值数组转化为字符数组
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        // 对字符数组进行排序  lambda 表达式形式
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        // 对排好序的字符数组进行拼接
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
