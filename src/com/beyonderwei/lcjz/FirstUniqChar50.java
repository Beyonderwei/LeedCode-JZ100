package com.beyonderwei.lcjz;

import java.util.HashMap;
import java.util.Map;

/*
 1. 题解：两次遍历数组，出现重复就将该字符在map中的值改为false，二次遍历时，即可找到第一个值为true的键即可

*/


public class FirstUniqChar50 {

    public char firstUniqChar(String s) {
        char[] str = s.toCharArray();
        Map<Character, Boolean> map = new HashMap<>(); // 用来保存第n个出现的字符串
        for (char c : str) {
            // map中应该使用 containsKey 来判断是否有某个键，返回值为boolean  因为map允许值为null，并且个数不限
            map.put(c, !map.containsKey(c));
        }
        for (char c: str) {
            // get 方法返回的对应的值，如果没有则返回null
            if (map.get(c)) return c;
        }
        return  ' ';
    }
}
