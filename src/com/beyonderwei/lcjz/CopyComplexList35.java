package com.beyonderwei.lcjz;

import java.util.HashMap;
import java.util.Map;

/*
 1. 题解：两次循环
         - 第一次循环，新建复制链表的节点，并通过Hash表建立原链表节点和新节点的映射
         - 再循环一次，把Hash表中的给新链表的next和random赋值
         - 返回第一个节点，直接从hash表中查询

*/


public class CopyComplexList35 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while(cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur =cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next); // 新节点的next指针 = 原节点的 next 指向的节点在Hash表中映射的节点
            map.get(cur).random = map.get(cur.random); // 新节点的 random 指针 = 原节点的 random 指向的节点在Hash表中映射的节点
            cur = cur.next;
        }
        return map.get(head);
    }
}
