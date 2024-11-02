package com.yingjie.leetcode.dp;

/**
 * <p>Title: L0474</p>
 * <p>Description: 474. 一和零</p>
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * <a href="https://leetcode.cn/problems/ones-and-zeroes/description/">...</a>
 */
public class L0474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            int zero = countZero(strs[i - 1]);
            int one = countOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (one <= k && zero <= j) {
                        dp[i][j][k] = Math.max(dp[i - 1][j - zero][k - one] + 1, dp[i - 1][j][k]);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int countZero(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }

    private int countOne(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }



}
