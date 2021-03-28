package com.beyonderwei.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS：利用队列的先进先出
 * 1. for循环中不能直接使用queue.size 因为每次会重新计算，因此需要提前计算好队列大小，保证上一层在一次for循环中全部出队列
 */


// 二叉树的层序遍历
public class TreeFloorTraverse {

    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int x) { val = x; }
    }

    private static List<List<Integer>> res = new LinkedList<>();

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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node1);
        floorTraverse(node1, queue);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }

    public static void floorTraverse(TreeNode root, Queue<TreeNode> queue) {
        while(!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
    }
}
