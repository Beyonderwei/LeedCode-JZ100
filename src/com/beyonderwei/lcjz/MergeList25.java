package com.beyonderwei.lcjz;

/*
 1. 题解：
        - 创建一个临时节点，cur指向该节点，比较 l1.val 和 l2.val，谁小就把cur的next指向谁并后移该节点，结束后cur指向下一个节点
        - 当有一个链表结束时，直接将后一个列表接到cur后面
        - 最后只需返回tmp.next 即可
 2. 问题：
        - 原有链表被改变，但节省内存
        - 或每次创建一个节点，构建一个新链表，就不会改变原有链表。
*/

public class MergeList25 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode cur = tmp;
        while(l1 != null && l2 !=null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null) cur.next = l2;
        else cur.next = l1;
        return tmp.next;
    }
}
