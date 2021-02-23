package com.beyonderwei.lcjz;

/*
 1. 妙的设计在于循环中判断 a == null 而不是 a.next,这样一来，即使没有交点，最终a b 会都等于null 跳出循环
    每个指针走过的距离可能都是链表长度之和，

 2. 参考：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
*/


public class ListIntersectionNode52 {

     class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
