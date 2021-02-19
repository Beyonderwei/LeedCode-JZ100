package com.beyonderwei.lcjz;

import java.util.LinkedList;
import java.util.Queue;


/*
 1. 题解：
    - 序列化：在树的层序遍历的基础上加一些内容，这里考虑到了完整的二叉树，包括子节点下的null元素
    - 反序列化：同样是基于层序遍历，与输出层序遍历（从节点取值）不同的是，现在是构建二叉树，从序列化中取值，添加到新的左右节点

 2. 参考：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/solution/mian-shi-ti-37-xu-lie-hua-er-cha-shu-ceng-xu-bian-/
*/


public class SerializeAndDeserializeTree37 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) { // 不等于null时才能添加左右节点，会将子节点的左右null也加进来
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,"); // 是null的话直接添加null
            }
        }
        res.deleteCharAt(res.length() - 1); // 去掉最后一个逗号
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        int i  = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++; // 无论是否等于null，添加完之后都要往后移一个，只是 null的话不再添加到节点中
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
