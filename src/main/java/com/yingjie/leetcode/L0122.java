package com.yingjie.leetcode;

/**
 * <p>Title: L0122</p>
 * <p>Description: 买卖股票的最佳时机 II</p>
 * 给定一个数组prices ，其中 prices[i] 表示股票第 i 天的价格。
 *
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以购买它，然后在同一天出售。
 * 返回你能获得的最大利润 。
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3
 *      <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">...</a>
 */
public class L0122 {

    /**
     * dp[i][j] 表示到下标为 i 的这一天，持股状态为 j 时，我们手上拥有的最大现金数
     * 状态j分为0和1两种，分别是第天持有和不持有股票
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }


    /**
     * 贪心算法
     * 对于 「今天的股价 - 昨天的股价」，得到的结果有 3 种可能：① 正数，② 000，③负数。贪心算法的决策是： 只加正数 。
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
}
