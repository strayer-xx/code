package com.yingjie.leetcode.subsequence;

/**
 * <p>Title: L0647</p>
 * <p>Description: 回文子串</p>
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class L0647 {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int j;
        int count = 0;
        for (int l = 0; l < len; l++) {
            for (int i = 0; i + l < len; i++) {
                j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                    count++;
                } else if (l == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;

                } else if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
