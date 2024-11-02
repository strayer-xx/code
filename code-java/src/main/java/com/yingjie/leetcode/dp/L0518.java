package com.yingjie.leetcode.dp;

import java.util.Arrays;

/**
 * <p>Title: L0518</p>
 * <p>Description:  零钱兑换 II</p>
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 链接：<a href="https://leetcode.cn/problems/coin-change-ii">...</a>
 */
public class L0518 {

    public static void main(String[] args) {
        System.out.println(new L0518().change(11, new int[]{2,3,5}));
    }

    public int change(int amount, int[] coins) {
        if(coins.length == 0)
            return 0;

        //dp[j]代表当钱包的总价值为j时，组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != 0) {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

}
