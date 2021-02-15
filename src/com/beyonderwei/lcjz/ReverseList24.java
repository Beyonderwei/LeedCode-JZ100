package com.beyonderwei.lcjz;

/*
 链表反转问题：
 1. 题解：链表问题先确定当前节点，前一个节点和下一个节点。先画图（重要），后看如何执行
        此题：next先与cur相同，当cur不为null，才赋值给next

*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseList24 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = head;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
