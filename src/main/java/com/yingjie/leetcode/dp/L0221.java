package com.yingjie.leetcode.dp;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * <a href="https://leetcode.cn/problems/maximal-square/">...</a>
 *
 */
public class L0221 {


    /**
     * dp[i + 1][j + 1] 表示以第 i 行、第 j 列为右下角的正方形的最大边长
     */
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        // 相当于已经预处理新增第一行、第一列均为0
        int[][] dp = new int[height + 1][width + 1];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == '1') {
                    // 求dp[row + 1][col], dp[row][col + 1], dp[row][col]三者最小值
                    dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                    maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
