package com.beyonderwei.lcjz;

import java.util.Arrays;

/*
 1. 题解：应当考虑使用小堆排序实现

*/

public class ArrayLeastNumbers40 {

    // 方法一： 直接使用Arrays的sort方法，实际上应该手写排序
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
