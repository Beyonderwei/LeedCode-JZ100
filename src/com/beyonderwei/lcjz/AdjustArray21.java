package com.beyonderwei.lcjz;

/*
 1. 题解：
        方法一：使数组的奇数在前，偶数在后，只需遍历整个数组，用一个值保存下一个奇数位置
        方法二：从左往右找到偶数，从右往左找到奇数，然后交换
            - 在找时需要判断left 是否小于 right
*/

public class AdjustArray21 {
    public int[] exchange1(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                int tmp = nums[index]; // 保存要被替换的值
                nums[index] = nums[i];
                nums[i] = tmp;
                index ++;
            }
        }
        return nums;
    }

    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
