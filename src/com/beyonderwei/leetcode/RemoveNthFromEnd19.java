package com.beyonderwei.leetcode;

/**
 * 题目：leetcode 19：删除链表的倒数第n个节点
 * 题解：双指针，找到要删的节点，然后删掉，注意可能删的是正数第一个节点的情况，因此需要对preLast 的不同情况进行判断
 */


public class RemoveNthFromEnd19 {

    public static void main(String[] args) {
        ListNode  n1 = new ListNode(1);
        ListNode  n2 = new ListNode(2);
        ListNode  n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode res = removeNthFromEnd(n1, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode last = head;
        ListNode preLast = null;

        for (int i = 0; i < n; i++) {
            if (front != null) front = front.next;
            else return null;
        }
        while(front != null) {
            preLast = last;
            front = front.next;
            last = last.next;
        }
        if (preLast == null) {
            return head.next;
        }else {
            preLast.next = last.next;
        }
        return head;
    }
}
