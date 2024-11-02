package com.yingjie.leetcode;

/**
 * <p>Title: L0028</p>
 * <p>Description: </p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中
 * 找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/2/26 10:24
 */
public class L0028 {

    public static void main(String[] args) {
        System.out.println(new L0028().strStr("sadbutsad", "sad"));
    }

    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        for (int i = 0; i <= n1 - n2; i++) {
            for (int j = 0; j < n2; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (j == n2 - 1) {
                    return i;
                }
            }

        }
        return -1;
    }
}
