package com.beyonderwei.lcjz;

import java.util.Deque;
import java.util.LinkedList;


/*
 1. 题解：通过维护一个单调递减的队列，以便每次 O1 时间获得窗口中最大的值
         - 如果队列的开始等于要删去的值，那么删除队列的第一个值
         - 如果要添加的值大于队列中的值，则删除小于要添加的值
         - 删除小于要添加的值后,添加要添加的值
         - 将最大值加入到结果列表
 2. 参考：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/
*/


public class MaxSlidingWindow59_1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int left = 1 - k, right = 0; right < nums.length; left++, right++) {
            // 1. 如果队列的开始等于要删去的值，那么删除队列的第一个值
            if (left > 0 && deque.peekFirst() == nums[left - 1]) deque.removeFirst();
            // 2. 如果要添加的值大于队列中的值，则删除小于要添加的值
            while (!deque.isEmpty() && deque.peekLast() < nums[right]) deque.removeLast();
            // 3. 删除小于要添加的值后,添加要添加的值
            deque.addLast(nums[right]);
            // 4. 将最大值加入到结果列表
            if (left >= 0) res[left] = deque.peekFirst();
        }
        return res;
    }
}
