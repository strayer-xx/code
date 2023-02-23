package com.yingjie.leetcode;

/**
 * <p>Title: L0343</p>
 * <p>Description: 整数拆分</p>
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class L0343 {

    public static void main(String[] args) {
        System.out.println(new L0343().integerBreak(10));
    }

    public int integerBreak(int n) {
        // 状态转移方程 dp[i] = Math.max(dp[i], Math.max(dp[i-j] * j, j * (i-j)))
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i] = Math.max(Math.max(dp[i-j] * j, (i-j) * j), dp[i]);
            }
        }
        return dp[n];
    }

}
