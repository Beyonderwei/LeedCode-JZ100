package com.beyonderwei.lcjz;

/*
 1. 题解：使用二叉树的中序遍历的倒序，即从最大值开始遍历，将结果和k作为类的属性，

 2. 参考：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
*/



public class KthLargestInTree54 {

    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        recure(root);
        return res;
    }

    // 先遍历右子树，再遍历根节点，最后遍历左子树  即中序遍历的倒序
    void recure(TreeNode root) {
        if(root == null) return;
        recure(root.right);
        // 对于每个节点的处理
        if(k == 0) return;
        if(--k == 0) this.res = root.val; // 实际上 --k == 0 时就已经是倒数第K个节点了
        recure(root.left);
    }
}
