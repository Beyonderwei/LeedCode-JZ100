package com.beyonderwei.lcjz;

/*
 1. 题解：从字符串后往前寻找，通过左右定位单词边界，然后从后往前添加单词到 StringBuilder
         - substring 左闭右开
         - trim 去掉前后空格
 2. 参考：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
*/


public class ReverseWords58_1 {

    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词  此时i处于空格处 j在单词最后一个字母，由于左闭右开，因此都要加一
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
}
