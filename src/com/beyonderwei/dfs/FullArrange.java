package com.beyonderwei.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 求数组的全排列，同样是套DFS框架，
 *
 */

public class FullArrange {

    private static List<List<Integer>> res = new LinkedList<>(); // 存放子集数据

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>(); // 存储已有的路径
        int[] arr = {0, 1, 2, 3, 4};
        dfs(arr, stack);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }

    // 通过DFS 解决全排列问题，输入一个不包含重复数字的数组，输出全排列
    public static void dfs(int[] arr, LinkedList<Integer> stack) {
        // 求arr的全排列，长度与数组相等时才添加
        if (stack.size() == arr.length) {
            res.add(new LinkedList<>(stack));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (stack.contains(arr[i])) continue;
            stack.add(arr[i]);
            dfs(arr, stack);
            stack.removeLast();
        }
    }
}
