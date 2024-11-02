package com.yingjie.leetcode.dp;

/**
 * 221. 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * <a href="https://leetcode.cn/problems/maximal-square/">...</a>
 *
 */
public class L0221 {


    /**
     * dp[i][j] 表示以第 i 行、第 j 列为右下角的正方形的最大边长
     */
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        int[][] dp = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == '1') {
                    if (row == 0 || col == 0) {
                        dp[row][col] = 1;
                    } else {
                        // 求dp[row + 1][col], dp[row][col + 1], dp[row][col]三者最小值
                        dp[row][col] = Math.min(Math.min(dp[row][col - 1], dp[row - 1][col]), dp[row - 1][col - 1]) + 1;
                    }

                    maxSide = Math.max(maxSide, dp[row][col]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
