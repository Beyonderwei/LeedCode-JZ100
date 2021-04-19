package com.beyonderwei.leetcode;

import java.util.*;

/**
 * 题目：力扣143  重排链表
 * 题解：
 *    1. 通过链表保存，两边get，然后调整指针
 *    2. 先找中间节点，反转链表、合并链表
 */


public class ReorderList143 {

    public static void main(String[] args) {
        
    }

    // 方法一 : 用一个数组保存指向链表的指针，然后进行交换
    public void reorderList01(ListNode head) {
     ArrayList<ListNode> list = new ArrayList<>();
     int length = 0;
     while(head != null) {
         list.add(head);
         head = head.next;
     }
     if(list.size() < 3) return;
     int right = list.size() - 1;
     int left = 0;
     int mid = (left + right) / 2;
     ListNode pre = null;
     while(left != mid) {
         list.get(left).next = list.get(right);
         left++;
         list.get(right).next = list.get(left);
         right--;
     }
     if(list.size() % 2 == 1) list.get(mid).next = null;
     else list.get(mid).next.next = null;
    }

    public void reorderList02(ListNode head) {
        // 1. 找到中间节点
        ListNode mid =findMid(head);
        // 2. 反转后半部分
        ListNode l2 = reverseList(mid);
        // 3. 链表合并
        while(head != mid) {
            ListNode tmpL1 = head.next;
            ListNode tmpL2 = l2.next;
            head.next = l2;
            head = tmpL1;
            l2.next = tmpL1;
            l2 = tmpL2;
        }
        head.next = null;
    }


    public ListNode findMid(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while(quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(head != null) {
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }
        return pre;
    }
}
