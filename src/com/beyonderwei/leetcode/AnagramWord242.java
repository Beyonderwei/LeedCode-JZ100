package com.beyonderwei.leetcode;

import java.util.*;

/**
 * 题目：判断两个字母是否是异位词：即单词组成的字母相同，切每个字母的个数也相同
 * 解法：将第一个字符串添加到map中，key 为字符，value 为数量，
 *      遍历第二个字符串的时候，找到对应的字符，减一，如果找不到或者减到-1，说明不是异位词
 */

public class AnagramWord242 {

    public static void main(String[] args) {
        String s = "beyonderwei";
        String t = "weibeyonder";
        boolean res = isAnagram(s, t);
        System.out.println(res);
    }

    public static boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                int tmp = map.get(s.charAt(i));
                map.put(s.charAt(i), ++tmp);
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < tLength; i++) {
            if (map.get(t.charAt(i)) != null) {
                int tmp = map.get(t.charAt(i));
                tmp--;
                if (tmp < 0) return false;
                map.put(t.charAt(i), tmp);
            } else {
                return false;
            }
        }
        return true;
    }
}
