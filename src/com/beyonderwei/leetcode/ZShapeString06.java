package com.beyonderwei.leetcode;

import java.util.LinkedList;

/**
 * 题目：leetcode 06题，Z字型排列字符串后，返回按行读取的结果
 * 题解：创建N个StringBuilder，放在list中，然后轮流放加字符串。
 */

public class ZShapeString06 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String res = convert(s, 3);
        System.out.println(res);
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        int n = s.length();
        int cnt = 0;
        int flag = -1;
        LinkedList<StringBuilder> list = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            list.get(cnt).append(c);
            if (cnt == 0 || cnt == numRows -1) flag = -flag;
            cnt += flag;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i).toString());
        }
        return builder.toString();
    }
}
