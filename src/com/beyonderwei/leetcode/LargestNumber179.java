package com.beyonderwei.leetcode;
import java.util.Arrays;

/**
 * 题目：leetcode 179，将数组的数组成一个最大的数
 * 题解：重写数组的比较方法，比较 ("" + y + x).compareTo("" + x + y)，再将排好序的数组从前往后遍历拼接成结果
 */

public class LargestNumber179 {

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] stringNums = new String[n];
        for (int i = 0; i < n; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNums, (x, y) -> {
            return ("" + y + x).compareTo("" + x + y);
        });
        StringBuilder builder = new StringBuilder();
        if (stringNums[0].equals("0")) return "0";
        for (int i = 0; i < n; i++) {
            builder.append(stringNums[i]);
        }
        return builder.toString();
    }
}
