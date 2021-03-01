package com.beyonderwei.lcjz;

/*
 1.题解：直接通过切片，拼接的方式或一个个添加到StringBuilder的方式即可实现

*/


public class ReverseLeftWords58_2 {

    public static String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }



}
