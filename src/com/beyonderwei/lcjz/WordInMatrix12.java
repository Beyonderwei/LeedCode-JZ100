package com.beyonderwei.lcjz;

/**
 * 12题
 * 题解网址：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
 */

/*
 1. 思路：
        遍历数组的每一个元素，以每个元素为起点进行深度优先搜索，递归回溯的方式，题解的只是单条路径，因此看不到回溯后再查搜索的过程

 2. 框架：
        dfs 方法：
            - board[i][j] = '\0'
            - 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接
            - board[i][j] = word[k];

 3. 参数：参考 dfs 方法注解

*/

public class WordInMatrix12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    /**
     *
     * @param board 二维数组
     * @param word 单词
     * @param i 起点第一维下标
     * @param j 起点第二维下标
     * @param k 搜索的字母在 word中的小标
     * @return
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 边界条件
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false; // 超过边界或不相等
        if(k == word.length - 1) return true; // 再往下搜索的k+1会超过字母长度
        board[i][j] = '\0'; // 保证走过的路径不可能会再相等，直接因为边界条件1返回false
        // 四个递归会先执行第一个，失败或成功之后才会继续执行后面的，而不是四个一起执行，失败的会向后回溯
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k]; // 一定要加，当有多条路径时回溯会用到，不然会导致某一条路径走过之后，之前走过的都无法再走了
        return res;
    }
}
