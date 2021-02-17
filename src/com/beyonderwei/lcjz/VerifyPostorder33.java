package com.beyonderwei.lcjz;

/*
 1. 题解：判断一个后序遍历是二叉搜索树，遍历顺序：左子树，右子树，根节点。
         递归判断每个子树的所有左子树值小于根节点，所有右子树值大于根节点。
         - 递归函数中先找到左子树右子树分界点，分界点左侧为左子树，分界点右侧为右子树

 2. 参数解释：
        - 参考 recur 函数

 3. 参考：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/

*/


public class VerifyPostorder33 {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    /**
     * @param postorder : 后续遍历数组
     * @param left : 当前（子）树的最左侧下标
     * @param root : 当前（子）树的根节点
     * @return
     */
    public boolean recur(int[] postorder, int left, int root) {
        if(left >= root) return true; // 左侧与根节点下标重合表示结束
        int right_start = left; // 从左侧开始搜索
        // 大于表示到右子树的第一个下标，已经比较了左子树的值小于根节点
        while(postorder[right_start] < postorder[root]) right_start++;
        // 初始化右子树的结束节点下标
        int right_end = right_start;
        // 比较了右子树的值小于根节点
        while(postorder[right_end] > postorder[root]) right_end++;
        // right_end == root 相等表示右子树都大于根节点，再递归左子树和右子树
        return right_end == root && recur(postorder, left, right_start - 1) && recur(postorder, right_start, root - 1);
    }

}
