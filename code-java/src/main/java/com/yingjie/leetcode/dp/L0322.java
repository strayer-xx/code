package com.yingjie.leetcode.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 链接：<a href="https://leetcode.cn/problems/coin-change">...</a>
 *
 * Next: {@link L0279} {@link L0518}
 */
public class L0322 {

    public static void main(String[] args) {
        System.out.println(new L0322().coinChange(new int[]{13,2,12}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0)
            return -1;

        //dp[j]代表当钱包的总价值为j时，所需要的最少硬币的个数
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
