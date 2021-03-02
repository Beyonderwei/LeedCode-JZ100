package com.beyonderwei.lcjz;

import java.util.Deque;
import java.util.LinkedList;


/*
 1. 题解：通过维护一个递减的双端队列来在 O1 时间内获取最大值

 2. 参考：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-dui-lie-de-zui-da-zhi-by-leetcod/
*/


public class MaxQueue59_2 {

    Deque<Integer> A, B;

    public MaxQueue59_2() {
        A = new LinkedList<>(); // 用来维护pop push操作
        B = new LinkedList<>(); // 用来获取最大值
    }

    public int max_value() {
        if(B.isEmpty()) return -1;
        return B.peekFirst();
    }

    public void push_back(int value) {
        // 如果前面有比push的值大的数，则直接删掉，然后在加入新的值
        while (!B.isEmpty() && B.peekLast() < value) B.pollLast();
        B.offer(value);
        A.offer(value);
    }

    public int pop_front() {
        if (A.isEmpty()) return -1;
        int tmp = A.pop();
        if (tmp == B.peekFirst()) B.pollFirst();
        return tmp;
    }

}
