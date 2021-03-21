package com.beyonderwei.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 求数组的所有子集，直接套用DFS框架
 */

public class SubSet {

    private static List<List<Integer>> res = new LinkedList<>(); // 存放子集数据

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>(); // 存储已有的路径
        int[] arr = {0, 1, 2, 3, 4};
        dfs(arr, 0, stack);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }

    // 通过DFS 解决子集问题，输入一个不包含重复数字的数组，输出所有的子集
    public static void dfs(int[] arr, int start, LinkedList<Integer> stack) {
        // 求arr的全部子集，直接add
        res.add(new LinkedList<>(stack));
        for (int i = start; i < arr.length; i++) {
            stack.add(arr[i]);
            dfs(arr, i + 1, stack);
            stack.removeLast();
        }
    }

}
