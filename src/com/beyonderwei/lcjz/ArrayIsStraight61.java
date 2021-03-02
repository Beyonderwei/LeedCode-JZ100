package com.beyonderwei.lcjz;

import java.util.HashSet;
import java.util.Set;


/*
 1. 题解：只要数组中的非零的数没有重复，且最大最小值的差小于5   那么就可以组成顺子，通过集合判断是否重复

 2. 参考：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/

*/


public class ArrayIsStraight61 {

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue;
            if(set.contains(num)) return false;
            else set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return (max - min) < 5;
    }
}
