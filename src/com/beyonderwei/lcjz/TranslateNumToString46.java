package com.beyonderwei.lcjz;

import java.util.Stack;

/*
 1. 题解：动态规划的方法实现，从一个字符，两个字符，三个字符找规律，写出状态转移方程
         - (pre * 10 + cur) > 25 时 dp = dp n-1
         - (pre * 10 + cur) < 25 时 dp = dp n-1  +  dp n-2

 2. 注意：可参考leedcode，直接将数字转换为字符串操作，更快一些，节省空间，将后两个字符的值直接与 “25”比较，妙！
*/


public class TranslateNumToString46 {

    public int translateNum(int num) {
        int res = 1;
        int fn_1 = 1; // dp n-1
        int fn_2 = 1; // dp n-2
        Stack<Integer> stack = new Stack<>();
        // 得到这个数的各个位的值放在 stack 中，最后从后往前取数
        while(num > 0) {
            int tmp = num % 10;
            stack.add(tmp);
            num /= 10;
        }
        // 依次弹出栈内元素
        int size = stack.size();
        int pre = 0, cur;
        for(int n = 1; n <= size; n++) {
            if(n == 1) {
                res = 1;
                pre = stack.pop();
                continue;
            }
            cur = stack.pop();
            // 06 和 6 算一种，因此加上判断 pre == 0
            if((pre * 10 + cur) > 25 || pre == 0) res = fn_1; // dp = dp n-1
            else res = fn_1 + fn_2; // dp = dp n-1  +  dp n-2
            fn_2 = fn_1;
            fn_1 = res;
            pre = cur;
        }
        return res;
    }
}
