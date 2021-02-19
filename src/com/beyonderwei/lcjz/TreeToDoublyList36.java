package com.beyonderwei.lcjz;

import java.util.ArrayList;

/*
 1. 两种方法，推荐第二种（参考的leedcode），第一种好理解，但时间复杂度和空间复杂度都高一些，具体解释参考代码注释

 2. 参考：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/

*/

public class TreeToDoublyList36 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // 方法一：中序遍历一遍，通过 ArrayList 保存，每个节点，然后遍历数组，完成前后指针的改变
    //        - 此方法多了一部分ArrayList 所占N个大小内存，遍历数组时，复杂度增加N 不推荐
    /*private ArrayList<Node> arrayList = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        recure(root);
        for(int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                arrayList.get(i).left = arrayList.get(arrayList.size() - 1);
                // 这里需要对长度小于1的二叉树特殊处理
                arrayList.get(i).right = arrayList.size() > 1 ? arrayList.get(i + 1) : arrayList.get(i);
            } else if (i == arrayList.size() - 1) {
                // 这里需要对长度小于1的二叉树特殊处理
                arrayList.get(i).left = arrayList.size() > 1 ? arrayList.get(i - 1) : arrayList.get(i);
                arrayList.get(i).right = arrayList.get(0);
            }else {
                arrayList.get(i).left = arrayList.get(i - 1);
                arrayList.get(i).right = arrayList.get(i + 1);
            }
        }
        return arrayList.get(0);
    }

    public void recure(Node root) {
        if(root == null) return;
        recure(root.left);
        arrayList.add(root);
        recure(root.right);
    }*/


    // 方法二：
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        // 特殊处理，head的left 指向pre，因为中序之后 cur为null，pre为链表最后一个节点
        head.left = pre;
        // 最后一个节点的right 指向head
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        // 直接使用中序遍历的框架
        if(cur == null) return;

        dfs(cur.left);

        // 重要：针对中序遍历的每个节点进行处理，每次执行到这里，cur就是中序遍历应该按顺序出现的节点中的一个
        // pre 对应链表的前一个节点，cur对应当前节点
        if(pre != null) pre.right = cur; // 前一个节点的right 指向当前节点
        else head = cur; // pre != null 即第一个节点，保存头结点 head 为链表的第一个节点
        cur.left = pre; // 当前节点的left指向前一个节点
        pre = cur; // 前一个节点变为当前节点， cur因为中序遍历，下次进入会自动的变为下一个节点

        dfs(cur.right);
    }

}
