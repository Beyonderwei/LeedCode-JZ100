package com.beyonderwei.lcjz;

/*
 1. 题解：临时节点保存左侧或右侧节点，每次交换左右节点，递归完成整个过程
         截止条件：要被交换的节点为null，则不再进行交换
 2. 返回：最后直接返回root，因为root的指向一直没有改变，一直指向根节点
*/


public class MirrorTree27 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode leftNode = root.left;
            root.left = root.right;
            root.right = leftNode;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }
}
