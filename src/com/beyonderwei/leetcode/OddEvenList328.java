package com.beyonderwei.leetcode;

/**
 * 奇偶链表：将链表的奇数位置在前，偶数位置的在后
 * 题解：分开得到两个链表，最后再合并，每个链表每次往前移动两个位置
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class OddEvenList328 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = oddEvenList(node1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode l1 = head;
        ListNode l1Head = head;
        ListNode l2 = head.next;
        ListNode l2Head = head.next;

        ListNode pre1 = null;
        ListNode pre2 = null;

        while (l2 != null && l1 != null) {
            if (l1.next != null) {
                pre1 = l1;
                l1 = l1.next.next;
                pre1.next = l1;
            }

            if (l2.next != null) {
                pre2 = l2;
                l2 = l2.next.next;
                pre2.next = l2;
            }
        }
        if (l1 == null) {
            pre1.next = l2Head;
        }else {
            l1.next = l2Head;
        }
        return l1Head;
    }
}
