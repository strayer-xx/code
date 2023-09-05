package com.yingjie.leetcode.dp;

/**
 * <p>Title: L0064</p>
 * <p>Description: </p>
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class L0064 {
    public static void main(String[] args) {
        System.out.println(new L0064().minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }

    /**
     * 动态规划
     */
    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < x; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < y; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < y; i++) {
            for (int j = 1; j < x; j++) {
                dp[j][i] = Math.min(dp[j - 1][i], dp[j][i - 1]) + grid[j][i];
            }
        }
        return dp[x - 1][y - 1];
    }
}
