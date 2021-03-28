package com.beyonderwei.slideWindow;


import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口解：最长子串
 * 1. map中的key-value不删，因此在确定left位置时，需要在 left 和 map.get(s.charAt(i)) + 1 中取大的
 */

// 求某个字符串不包含重复字符的最长子串
public class MaxSubString {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 1;
        for(int i = 0; i < s.length(); i++)  {
            if(map.get(s.charAt(i)) != null) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
