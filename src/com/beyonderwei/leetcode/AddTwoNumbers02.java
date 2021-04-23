package com.beyonderwei.leetcode;

/**
 * 题目：leetcode 02 计算两个数的和
 * 题解：通过模拟加法计算，返回的值放入链表中（每次新建一个节点），注意最后一个l1 l2都为null时，需要判断进位是否为1的特殊情况
 */

public class AddTwoNumbers02 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0; // 进位
        ListNode res = new ListNode(0);
        ListNode preListNode = res;
        while (l1 != null || l2 != null) {
            int value = 0;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            value += i;
            i = value / 10;
            value = value % 10;
            ListNode listNode = new ListNode(value);
            preListNode.next = listNode;
            preListNode = listNode;
        }
        if (i != 0) {
            ListNode listNode = new ListNode(i);
            preListNode.next = listNode;
        }
        return res.next;
    }
}
