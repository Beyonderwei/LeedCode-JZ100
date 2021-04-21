package com.beyonderwei.leetcode;

/**
 * 题目：力扣61题，旋转链表，链表的节点向后移动k个，输出移动后的链表
 * 题解：找到要被分开的节点位置，然后进行拼接，需要先求得链表的长度，避免k过大，采用取余的操作，减少操作次数
 */

public class RotateRight61 {

    public static void main(String[] args) {

    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode keyNode = head;
        ListNode cacheHead = head;
        ListNode preKeyNode = null;
        int length = 1;
        while (head.next != null) {
            head = head.next;
            length ++;
        }
        if (length == 1 || k == 0) return cacheHead;

        k = k % length;
        if (k == 0) return cacheHead;
        for (int i = 0; i < length - k; i++) {
            preKeyNode = keyNode;
            keyNode = keyNode.next;
        }
        ListNode res = keyNode;
        while (keyNode.next != null) keyNode = keyNode.next;
        keyNode.next = cacheHead;
        preKeyNode.next = null;
        return res;
    }

}
