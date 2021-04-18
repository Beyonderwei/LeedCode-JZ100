package com.beyonderwei.meituan;

import java.util.*;

/**
 * 题目描述：对栈进行排序，只能使用栈结构
 * 题解：用一个额外的栈，来保存最终排序数字
 */

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        Stack<Integer> res = sortStack(stack);
        System.out.println(res.toString());  // toString  是从栈底到栈顶的顺序打印的
    }

    static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> res = new Stack<>();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            if (!res.isEmpty() && res.peek() >= tmp) {
                res.push(tmp);
            }else {
                while (!res.isEmpty() && res.peek() < tmp) {
                    stack.push(res.pop());
                }
                res.push(tmp);
            }
        }
        return res;
    }
}
