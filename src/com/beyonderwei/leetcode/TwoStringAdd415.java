package com.beyonderwei.leetcode;

/**
 * 题目描述：大数相加，两个字符串相加
 * 解法：模拟做加法的过程
 *
 */

public class TwoStringAdd415 {
    public static void main(String[] args) {
        String s1 =    "1";
        String s2 = "9";
        String res = addStrings(s1, s2);
        System.out.println(res);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int l1 = num1.length();
        int l2 = num2.length();
        int length = Math.min(l1, l2);
        int carry = 0;
        for (int i = 1; i <= length; i++) {
            int m = num1.charAt(l1 - i) - '0';
            int n = num2.charAt(l2 - i) - '0';
            int tmp = m + n + carry;
            if(tmp >= 10) {
                carry = 1;
                builder.append(tmp % 10);
            } else {
                carry = 0;
                builder.append(tmp);
            }

        }
        for (int i = length + 1; i <= Math.max(l1, l2); i++) {
            int count = 0;
            if(l1 <= l2) {
                count = num2.charAt(l2 -i) - '0';
            } else {
                count = num1.charAt(l1 - i) - '0';
            }
            int tmp = count + carry;
            if (tmp >= 10) {
                carry = 1;
                builder.append(tmp % 10);
            } else {
                carry = 0;
                builder.append(tmp);
            }
        }
        if (carry == 1) builder.append(1);
        return builder.reverse().toString();
    }
}
