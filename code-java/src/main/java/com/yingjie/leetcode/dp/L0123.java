package com.yingjie.leetcode.dp;

/**
 * <p>Title: L0123</p>
 * <p>Description: 买卖股票的最佳时机 III</p>
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/">...</a>
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 股票问题解题模板：<a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-tao-mo-ban-ji-xing-dai-ma-bi-zhao-yan-0ap8/">...</a>
 *
 * Next: {@link L0188}
 */
public class L0123 {


    /**
     * dp[i][j] 表示到下标为 i 的这一天，持股状态为 j 时，我们手上拥有的最大收益
     * 状态j分为四种，分别是第 i 天 第一次买入、第一次卖出、第二次买入、第二次卖出
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] + prices[i]);
        }
        return dp[n-1][3];
    }

}
