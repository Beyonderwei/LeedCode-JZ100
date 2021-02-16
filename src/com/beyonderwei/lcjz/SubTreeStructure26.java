package com.beyonderwei.lcjz;

/*
 1.题解：
        - includeSubTree：针对A的某个节点，前序遍历A的值和B的值，是子树返回B，不是子树返回false。
        - isSubStructure 前序遍历A，遍历的每个节点作为新的A，调用includeSubTree，各个节点返回的结果之间是或关系
                         即有一个结果为true，表示includeSubTree结果为true，即B是A的子结构。

*/



public class SubTreeStructure26 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 前、中或后序遍历整个A，然后执行isSubStructure（A, B） 有一个返回true便结束。
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (includeSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    // A B 节点固定，判断当前的B是否包含在A中从根节点依次往左右节点比较
    public boolean includeSubTree(TreeNode A, TreeNode B) {
        if (B == null) return true; // 等于null表示没有节点结束
        if (A == null || A.val != B.val) return false; // 有一个为false便不再执行，表示不包含。注意 A == null 放在 A.val != B.val 之前，防止空指针异常
        return includeSubTree(A.left, B.left) && includeSubTree(A.right, B.right);
    }

}
