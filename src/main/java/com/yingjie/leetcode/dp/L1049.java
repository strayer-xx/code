package com.yingjie.leetcode.dp;

/**
 * <p>Title: L1049</p>
 * <p>Description: 最后一块石头的重量 II</p>
 *
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 */
public class L1049 {

    public static void main(String[] args) {
        System.out.println(new L1049().lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }

    /**
     * dp[i][j]代表从[0,i]区间内。找出比target小的最大方案
     */
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        if (n == 1) {
            return stones[0];
        }

        // 就是把两堆石头尽量分成相同重量，还是01背包问题
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < n; i++){
            int num = stones[i];
            for (int j = 0; j <= target; j++) {
                if (i == 0) {
                    if (num <= j) {
                        dp[i][j] = num;
                    }
                    continue;
                }
                if (num <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + num);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int other = sum - dp[n-1][target];
        return other - dp[n-1][target];
    }

    /**
     * 对比上一种方法有何不同
     * dp[i][j]代表从前 i 个内。找出比target小的最大方案
     */
    public int lastStoneWeightII2(int[] stones) {
        int n = stones.length;
        if (n == 1) {
            return stones[0];
        }

        // 就是把两堆石头尽量分成相同重量，还是01背包问题
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++){
            int num = stones[i - 1];
            for (int j = 0; j <= target; j++) {
                if (num <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + num);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int other = sum - dp[n][target];
        return other - dp[n][target];
    }

    /**
     * 这道题看上去懵，其实就是把两堆石头尽量分成相同重量，还是01背包问题
     *
     * 一堆石头重量是dp[sum / 2]，另一堆是sum - dp[sum / 2]
     */
    public int lastStoneWeightIIPro(int[] stones) {
        int n = stones.length;
        if (n == 1) {
            return stones[0];
        }

        // 就是把两堆石头尽量分成相同重量，还是01背包问题
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target+1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }
        int other = sum - dp[target];
        return other - dp[target];
    }
}
