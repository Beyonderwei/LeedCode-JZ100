package com.beyonderwei.lcjz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

 1. 题解：在32_1的基础上，通过每次循环queue.size() 大小的，即每层元素个数，将每层元素保存到tmp，然后再添加到res中

 2. 注意：
        - for (int i = queue.size(); i > 0; i--) 因为循环中而queue.add 改变了大小，所以只能这样写
*/


public class PrintTreeByLayer32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public  List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(); // 返回一个空的数组
        Queue<TreeNode> queue = new LinkedList<>(); // LinkedList的add 和 poll方法 队列
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root); // 初始化添加根节点
        while (!queue.isEmpty()) { // 队列为空表示遍历结束
            List<Integer> tmp = new ArrayList<>(); // 一定要每次新建，如果add到res后清空，实际上是清空的add到res中的tmp
            // 不能使用 int i = 0; i < queue.size(); i++   因为每次循环都会重新计算queue.size()，而queue.add 改变了大小
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left); // 添加左节点到队列
                if (node.right != null) queue.add(node.right); // 添加右节点到队列
            }
            res.add(tmp);
        }
        return res;
    }
}
