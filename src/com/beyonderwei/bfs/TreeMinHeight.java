package com.beyonderwei.bfs;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 通过BFS求二叉树的最小高度，直接套用框架，截止条件为 该节点的左右子树均为null，直接返回step
 * BFS：通常用来求最短路径问题，即从起点到终点的最短路径，如关系网中联系的层数（次数）、坐车等车的最少换乘数
 */

public class TreeMinHeight {

    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int x) { val = x; }
    }

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
        int height = minHeight(node1);
        System.out.println(height);
    }

    public static int minHeight(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int step = 1; // 默认根节点高度为1
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return step;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            step++;
        }
        return 0;
    }
}
