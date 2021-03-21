package com.beyonderwei.dfs;

import java.util.LinkedList;
import java.util.List;


/**
 * 与求数组的所有子集方法相同，只是在添加到res时进行了判断，stack等于所需大小时才添加到res中，并直接返回
 */

public class NumCombination {

    private static List<List<Integer>> res = new LinkedList<>(); // 存放子集数据

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>(); // 存储已有的路径
        int[] arr = {0, 1, 2, 3, 4};
        dfs(arr, 0, stack);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }

    // 通过DFS 得到K个数字的组合，输入一个不包含重复数字的数组，输出所有的组合
    public static void dfs(int[] arr, int start, LinkedList<Integer> stack) {
        // 求k个数字的的组合
        if (stack.size() == 3) {
            res.add(new LinkedList<>(stack));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            stack.add(arr[i]);
            dfs(arr, i + 1, stack);
            stack.removeLast();
        }
    }
}
