package com.beyonderwei.leetcode;

/**
 * 题目:判断二叉树是否是平衡二叉树
 * 解法：后序遍历，递归，每次返回当前节点的高度（即左子树高度和右子树高度中大的那个加一）
 * 对于每一个节点，判断左右子树高度差是否大于一
 */

public class BalanceTree110 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        recure(root);
        return res;
    }

    public int recure(TreeNode root) {
        if(root == null) return 0;
        int left = recure(root.left);
        int right = recure(root.right);
        if(Math.abs(left - right) > 1) res = false;
        return Math.max(left, right) + 1;
    }
}
