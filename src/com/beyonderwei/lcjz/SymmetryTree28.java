package com.beyonderwei.lcjz;

/*
 1. 题解：递归对比左节点的左值与右节点的右值，左节点的右值和右节点的左值
        - 当L和R 都为null时返回true
        - 当L和R一个为 null 时返回false
        - 都不为null 时，执行递归，各个递归结果之间用与连接（因为要求都为true才是对称二叉树）
 2. 特殊情况，根节点为null，直接返回true
*/


public class SymmetryTree28 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirrorTree(root.left, root.right);
    }

    public boolean isMirrorTree(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L != null && R != null) return (L.val == R.val) && isMirrorTree(L.left, R.right) && isMirrorTree(L.right, R.left);
        else return false;
    }
}
