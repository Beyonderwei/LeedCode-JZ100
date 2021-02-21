package com.beyonderwei.lcjz;

import java.util.HashMap;
import java.util.Map;


/*
 1. 题解：dp[i] 含义： 核心在于对数组中每个字符为结尾的子串字符数的最大值，遍历一遍即可，（重点理解这句话）

 2. 参考：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
*/


public class LengthOfLongestSubstring48 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        int res = 0; // 最终的结果，每次取最大值
        int tmp = 0; // 临时变量，代表dp[i-1] 。 dp[i] 表示以当前字符为结尾的字符串，最长不重复子串大小，子串也要以 dp[i] 结尾，这样从所有以每个字符为结尾的中取最大值
        for(int i = 0; i < str.length; i++) {
            // 获取字符的下标，如果没有则等于 -1
            int pre = map.get(str[i]) == null ? -1 : map.get(str[i]); // 获取索引 i
            map.put(str[i], i); // 更新哈希表
            tmp = tmp < i - pre ? tmp + 1 : i - pre; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // 从dp[i] 中找最大的
        }
        return res;
    }
}
