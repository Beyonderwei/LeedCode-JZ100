package com.beyonderwei.lcjz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 1. 题解：广度优先搜索（BFS）问题，通过队列实现，不断的循环添加左右节点到res，由于先进先出的特点，会逐层打印

 2. 注意：
        - 队列使用Java中的 LinkedList的add 和 poll方法
        - 遍历的数据先放到变长数组ArrayList中
        - 然后最后将ArrayList 数据放到数组中返回

 3. 参考：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/solution/mian-shi-ti-32-i-cong-shang-dao-xia-da-yin-er-ch-4/
*/


public class PrintTree32_1 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0]; // 返回一个空的数组
        Queue<TreeNode> queue = new LinkedList<>(); // LinkedList的add 和 poll方法 队列
        queue.add(root); // 初始化添加根节点
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!queue.isEmpty()) { // 队列为空表示遍历结束
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if (node.left != null) queue.add(node.left); // 添加左节点到队列
            if (node.right != null) queue.add(node.right); // 添加右节点到队列
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
