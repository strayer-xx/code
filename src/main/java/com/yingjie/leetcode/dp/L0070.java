package com.yingjie.leetcode.dp;

/**
 * <p>Title: L0070</p>
 * <p>Description: 爬楼梯</p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class L0070 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n == 1) {
            return dp[1];
        }
        dp[2] = 2;
        for (int i = 3; i < n + 1; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
