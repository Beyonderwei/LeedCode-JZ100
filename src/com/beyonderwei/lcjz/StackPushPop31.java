package com.beyonderwei.lcjz;

import java.util.Stack;


/*
 1. 题解：模拟栈的压入和弹出过程，用一个栈来维护这个过程，由于没有重复的数字，因此只需要对比栈的值与弹出的第一个是否相等，相等就从stack
         弹出，并后移index，注意这里一定要使用while，因为可能一次连续压入几个再弹出几个，最后循环整个栈后，判断stack是否为空，空即符
         合，不为空就不符合，具体参考leedcode解答的图解。

 2. 参考：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/

*/


public class StackPushPop31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i : pushed) {
            stack.push(i);
            // 这里一定要用while，不能用if，因为可能连续弹出多个
            // 要判断是否为空，不然stack.peek() 会出现空指针，因为是while循环。
            while(!stack.isEmpty() && stack.peek().equals(popped[index])) {
                index ++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
