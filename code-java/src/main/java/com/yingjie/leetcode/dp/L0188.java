package com.yingjie.leetcode.dp;

/**
 * <p>Title: L0188</p>
 * <p>Description: 买卖股票的最佳时机 IV</p>
 *
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格，和一个整型 k 。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * 链接：<a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv">...</a>
 *
 * Next: {@link L0309}
 */
public class L0188 {

    public static void main(String[] args) {
        new L0188().maxProfit(2, new int[]{2,1,4,5,2,9,7});
    }

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int kLen = 2 * k;
        int max = 0;
        int[][] dp = new int[len][kLen];
        for (int i = 0; i < kLen; i++) {
            dp[0][i] = (i % 2) == 0 ? -prices[0] : 0;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < kLen; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], -prices[i]);
                } else if (j % 2 == 1){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
