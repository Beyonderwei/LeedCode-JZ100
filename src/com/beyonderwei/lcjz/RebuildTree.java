package com.beyonderwei.lcjz;

import java.util.HashMap;
import java.util.Map;


/*
 1. 思路：
        递归的方法，从当前树的前序得到根节点，中序得到左子树和右子树，
        以左子树为例：
            - 中序中的左子树即为该左子树的中序遍历
            - 前序中往后查找左子树元素个数，即为该左子树的前序遍历
            - 针对该左子树重复上述过程（右子树也是同样方法）
         注：indexMap 的作用是以空间换时间，Map在搜索根节点在中序遍历的下标时，时间复杂度 O(1)
 2. 框架：
        myBuildTree 方法
            - 建立当前（子）树根节点 root
            - root.left = myBuildTree();
            - root.right = myBuildTree();
 3. 参数：
        参考myBuildTree方法上的注释（重要），因为每个参数有固定的含义，直接按照规律写就可以，用来解释框架中第2、3步中参数的含义
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 代码来自 LeedCode 的官方题解
 */
public class RebuildTree {

    private Map<Integer, Integer> indexMap;

    /**
     * 每次调用该方法时，各参数含义如下
     * @param preorder: 整个树的前序排列的数组(固定不变)
     * @param inorder: 整个树的中序排列的数组(固定不变)
     * @param preorder_left: 当前(子)树的前序遍历的最左侧点在 preorder 中的下标
     * @param preorder_right: 当前(子)树的前序遍历的最右侧点在 preorder 中的下标
     * @param inorder_left: 当前(子)树的中序遍历的最左侧点在 inorder 中的下标
     * @param inorder_right: 当前(子)树的中遍历列的最右侧点在 inorder 中的下标
     * @return 得到的节点
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        // 终止条件，直接指向 null
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点，在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_left]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_left]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // preorder_left + 1 : 左子树的前序遍历的最左侧点在 preorder 中的下标   inorder_left：左子树的中序遍历的最左侧点在 inorder 中的下标
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // preorder_left + size_left_subtree + 1 : 右子树的中序遍历的最左侧点在 inorder 中的下标
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
