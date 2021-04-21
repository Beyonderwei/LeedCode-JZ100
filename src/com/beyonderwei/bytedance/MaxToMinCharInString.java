package com.beyonderwei.bytedance;

import java.util.*;

/**
 * 题目：给定一个字符串，按照出现次数从少到多的顺序输出字符
 * 解析：遍历String，通过map记录每个字符出现的次数，然后对Map排序，按照值排序，然后顺序输出map的key
 */

public class MaxToMinCharInString {

    public static void main(String[] args) {
        String s = "aabccddefeewylhhac";
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                int tmp = map.get(s.charAt(i));
                map.put(s.charAt(i), tmp + 1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey());
        }
    }
}
