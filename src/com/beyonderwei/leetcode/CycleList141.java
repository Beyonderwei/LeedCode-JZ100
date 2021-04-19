package com.beyonderwei.leetcode;

import java.util.*;

public class CycleList141 {

    public static void main(String[] args) {

    }

    /**
     * map 方式判断
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
            }else {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针的方式实现
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (slow == quick) return true;
        }
        return false;
    }
}
