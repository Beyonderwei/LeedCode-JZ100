package com.beyonderwei.lcjz;


/*
 1. 题解：采用DFS，相当于使用的后序遍历，树的深度为左子树和右子树中深度大的加一，对于左右子树采用同样的递归方式
         或也可以采用层序遍历的方式，每遍历一层，计数器加一，最后得到树的深度。

 2. 参考：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
*/


import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxDepth55_1 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }


    public int maxDepth(TreeNode root) {
        // 1. 如果为空则直接返回0
        if(root == null) return 0;
        // 2. 如果不为空，返回结果左子树或 右子树深度大的那个加一
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 方法二   层序遍历，注意每次while循环时，将该层节点全部poll出去
    /*public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
            res++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left); // 添加左节点到队列
                if (node.right != null) queue.add(node.right); // 添加右节点到队列
            }
        }
        return res;
    }*/
}
