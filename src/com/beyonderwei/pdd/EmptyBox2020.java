package com.beyonderwei.pdd;

import java.util.*;

/**
 * 题目来源：牛客2020拼多多真题
 * 多多鸡有N个魔术盒子（编号1～N），其中编号为i的盒子里有i个球。
 * 多多鸡让皮皮虾每次选择一个数字X（1 <= X <= N），多多鸡就会把球数量大于等于X个的盒子里的球减少X个。
 * 通过观察，皮皮虾已经掌握了其中的奥秘，并且发现只要通过一定的操作顺序，可以用最少的次数将所有盒子里的球变没。
 * 那么请问聪明的你，是否已经知道了应该如何操作呢？
 *
 * 第一行，有1个整数T，表示测试用例的组数。
 * （1 <= T <= 100）
 * 接下来T行，每行1个整数N，表示有N个魔术盒子。
 * （1 <= N <= 1,000,000,000）
 *
 * 共T行，每行1个整数，表示要将所有盒子的球变没，最少需要进行多少次操作。
 */


public class EmptyBox2020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); // 测试数据组数
        int[] testNums = new int[count];
        int max = 0;
        for (int i = 0; i < count; i++) {
            int N = sc.nextInt();
            testNums[i] = N;
            max = Math.max(max, N);
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i <= max; i++) {
            int tmp = list.get(i / 2) + 1;
            list.add(tmp);
        }

        for (int i = 0; i < count; i++) {
            System.out.println(list.get(testNums[i]));
        }
    }
}
