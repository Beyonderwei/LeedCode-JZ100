package com.beyonderwei.lcjz;

import java.util.Stack;

/*
 1. 题解：栈A完成top函数，B维护最小值，完成min
        - 当向A中push值时，如果小于等于B的值，就也加入B中
        - 当从A中弹出数据时，如果和B中的相等，也把B的弹出，因为B存的是A pop时，小于等于pop的值
 2. 注意：
        - A 栈实际上是实现了队列，栈的add和push方法只是一个没返回值，一个有返回值（push的值）
*/

public class WithMinStack30 {

    Stack<Integer> A, B;
    /** initialize your data structure here. */
    public WithMinStack30() {
        A = new Stack<>(); // 用于 pop 和 top
        B = new Stack<>(); // 用于维护最小值在该栈顶
    }

    public void push(int x) {
        A.push(x);
        if (B.isEmpty() || B.peek() >= x) B.push(x);
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

}
