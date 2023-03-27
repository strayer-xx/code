package com.yingjie.leetcode;

/**
 * <p>Title: L0005</p>
 * <p>Description: 最长回文串</p>
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class L0005 {

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        L0005 solution = new L0005();
        assert "bab".equals(solution.longestPalindrome(s1)) : "failed1";
        assert "bb".equals(solution.longestPalindrome(s2)) : "failed2";
    }

    /**
     * 动态规划
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        // 主要理解为什么要用长度去循环
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }
}
