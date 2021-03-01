package com.beyonderwei.lcjz;

/*
 1. 题解：通过所有的数字之间异或，结果即为单独的数字，因为相同的位异或后为0，但此题需要分组，将不同的两个数分到不同的组

 2. 参考：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/

*/


public class SingleNumbers56_1 {

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        // 按位异或所有的数，结果为单独的两个数 a b 的异或
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        // 找到ab异或中不为0的那一位，作为以后的分组条件
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        // 分组异或
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n; // 第一个分组，异或得到单独的那个数字
            } else {
                b ^= n; // 第二个分组，异或得到单独的那个数字
            }
        }
        return new int[]{a, b};
    }

}
