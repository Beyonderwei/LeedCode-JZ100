package com.beyonderwei.lcjz;

/*
 1. 题解：在计算二叉树的深度的基础上，基于深度优先搜索，每次判断左右子树的高度差，通过类成员变量来标注是否是平衡二叉树，一旦非平衡，后面不再进行判断

 2. 参考：也可以参考leedcode的方式，返回 -1的形式

*/


public class TreeIsBalanced55_2 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        treeDeep(root);
        return this.res;
    }

    public int treeDeep(TreeNode node) {
        if(!res) return -1; // 如果已经是非平衡二叉树的话，直接返回
        if(node == null) return 0;
        int left = treeDeep(node.left);
        int right = treeDeep(node.right);
        if(Math.abs(left - right) > 1) this.res = false; // 非平衡二叉树
        return Math.max(left, right) + 1;
    }
}
