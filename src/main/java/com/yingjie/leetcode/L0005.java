package com.yingjie.leetcode;

/**
 * <p>Title: L0005</p>
 * <p>Description: 最长回文串</p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/4/16 20:29
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
