package com.beyonderwei.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 1. 只要有if判断满足条件的个数一定要加 return
 * 2. 有start for循环中就不需要加入是否已经入栈的判断（if (stack.contains(arr[i])) continue;）
 * 3. 子集和 组合  需要start 因为不能重复的添加（因为 [1, 2] 和 [2, 1]属于相同的子集或组合），而全排列的话没有start
 * 4. 由于栈是先进后出，因此想要得到由前到后的子集、组合 需要从后往前遍历
 */

// 求全排列：321 231 312 132 213 123    满足 stack.size() == 3 时一定要加return
public class FullArrange {

    private static LinkedList<LinkedList<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        LinkedList<Integer> stack = new LinkedList<>();
        dfs(arr, stack);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static void dfs(int[] arr, LinkedList<Integer> stack) {
        if (stack.size() == 3) {
            res.add(new LinkedList<>(stack));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (stack.contains(arr[i])) continue;
            stack.push(arr[i]);
            dfs(arr, stack);
            stack.poll();
        }
    }
}
