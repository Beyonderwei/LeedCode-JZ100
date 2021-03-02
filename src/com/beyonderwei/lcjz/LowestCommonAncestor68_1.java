package com.beyonderwei.lcjz;


/*
 1. 题解：pq一但在root 的左右侧，则说明root 就是pq的最近公共祖先，不在左右侧的时候，root变为pq所在侧的下一个节点，并重复此过程

*/


public class LowestCommonAncestor68_1 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if ((p.val - root.val) * (q.val - root.val) <= 0) return root;
            else root = p.val > root.val ? root.right : root.left;
        }
        return root;
    }
}
