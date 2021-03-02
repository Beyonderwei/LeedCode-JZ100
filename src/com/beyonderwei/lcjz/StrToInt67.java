package com.beyonderwei.lcjz;

/*
 1. 题解：通过符号位判断正负号，通过 res = 10 * res + (str.charAt(j) - '0'); 获得字符串的数值，在之前判断是否超过Int范围

 2. 参考：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/solution/mian-shi-ti-67-ba-zi-fu-chuan-zhuan-huan-cheng-z-4/
*/


public class StrToInt67 {
    public int strToInt(String str) {
        str = str.trim(); // 去掉前后空格
        if(str.isEmpty()) return 0;
        int res = 0, i = 0, sign = 1; // 符号位默认为正
        int max = Integer.MAX_VALUE / 10;

        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;

        // 循环字符串后面的部分
        for (int j = i; j < str.length(); j++) {
            // 1. 判断是否在0-9范围内，不在直接跳出
            if (str.charAt(j) < '0' || str.charAt(j) > '9') break;
            // 2. 判断是否可能超过最大值，超过直接返回最大或者最小值
            if(res > max || (res == max && str.charAt(j) > '7')) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            // 3. 计算得到当前字符转数字的值
            res = 10 * res + (str.charAt(j) - '0');
        }
        return  res * sign;
    }
}
