package com.beyonderwei.lcjz;


/*
 1. 题解：通过两个间隔 k的指针，一起向前移动，前一个到头，直接返回后一个即可
        使时间复杂度从 O(n+k) 降为 O(n)

 2. 参数：
        - forward ：前面的指针
        - res ：最终要返回的，最后指向倒数第k个节点的指针
*/

public class ListLastKNode22 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode forward = head, res = head;
        for(int i = 0; i < k-1 ; i++) {
            forward = forward.next;
        }
        while(forward.next != null) {
            forward = forward.next;
            res = res.next;
        }
        return res;
    }
}
