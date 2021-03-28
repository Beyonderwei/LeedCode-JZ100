package com.beyonderwei.dfs;

import java.util.*;


/**
 * 二叉树的所有路径：
 * 1. 前序遍历的方式，套用框架，先add 左右子树都结束时 removeLast（linkedList 不能用 pop）  栈可以用pop
 */

public class TreeRoute {

    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int x) { val = x; }
    }

    private static List<List<Integer>> res = new LinkedList<>();
    private static LinkedList<Integer> stack = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        dfs(node1);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        stack.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new LinkedList<>(stack));
            // 不能加return
        }
        dfs(root.left);
        dfs(root.right);
        stack.removeLast(); // 只能用 removeLast 不能用 pop
    }
}
