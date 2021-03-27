package com.beyonderwei.dfs;

import java.util.LinkedList;

/**
 * 1. 只要有if判断满足条件的个数一定要加 return
 * 2. 有start for循环中就不需要加入是否已经入栈的判断（if (stack.contains(arr[i])) continue;）
 * 3. 子集和 组合  需要start 因为不能重复的添加（因为 [1, 2] 和 [2, 1]属于相同的子集或组合），而全排列的话没有start
 * 4. 由于栈是先进后出，因此想要得到由前到后的子集、组合 需要从后往前遍历
 */

// 求数组的所有组合(2个数的组合) [2, 1] [3, 1] [3, 2]
public class NumCombination {

    private static LinkedList<LinkedList<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        LinkedList<Integer> stack = new LinkedList<>();
        dfs(arr, stack, 0);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static void dfs(int[] arr, LinkedList<Integer> stack, int start) {
        if (stack.size() == 2) {
            res.add(new LinkedList<>(stack));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            stack.push(arr[i]);
            dfs(arr, stack, i + 1);
            stack.poll();
        }
    }
}
