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
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
