package com.yingjie.leetcode.dp;

import java.util.Arrays;

/**
 * <p>Title: L0279</p>
 * <p>Description: </p>
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 链接：<a href="https://leetcode.cn/problems/perfect-squares">...</a>
 *
 * 先看 {@link L0322}
 */
public class L0279 {


    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        return dp[n];
    }
}
