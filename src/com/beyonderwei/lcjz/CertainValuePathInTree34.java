package com.beyonderwei.lcjz;

import java.util.LinkedList;
import java.util.List;


/*
 1. 题解：前序遍历整个二叉树，通过 一个 LinkedList path 保存所走路径，每循环结束删除进入是加入的节点，在每个节点判断目标值是否等于0
         如果等于 0， 就把当前数组加入到res中
         - 就是前序遍历框架，加一些额外的代码
 2. 参考：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/

*/


public class CertainValuePathInTree34 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    // 注。tar的值一直都是传递给递归函数的值，无需再加回来，核心思想就是遍历，遇到tar==0就加到结果列表
    void recur(TreeNode root, int tar) {
        if(root == null) return; // 不能加 || tar < 0  因为二叉树中既有正值也可能有负值，可能上面不满足  到下面就满足了
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
