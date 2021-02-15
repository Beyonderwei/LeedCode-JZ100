package com.beyonderwei.lcjz;


/*
 1. 题解：遍历找到要删除的节点的位置，但此时需要一个指向要删除的节点的前一个节点的指针，将前一个节点的next指向要删除的节点的next即可

 2. 注意点：
        - 如果是删除第一个节点需要单独处理
        - 如果链表没有该值，因此需要防止访问到null.val
*/

public class DelateListNode18 {

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next; // 如果删除的是第一个节点，直接返回head.next
        ListNode newHead = head; // 定义一个节点，方便返回
        ListNode pre = head; // 指向head的前一个节点
        // 防止head为null时访问head.val 报错空指针
        while(head != null && head.val != val) {
            pre = head;
            head = head.next;
        }
        // 处理没有找到要删除的节点的情况
        if(head == null) return newHead;
        // 删除几点，只需改变指向
        pre.next = head.next;
        return newHead;
    }
}
