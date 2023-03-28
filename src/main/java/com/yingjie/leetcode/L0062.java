package com.yingjie.leetcode;

/**
 * <p>Title: L0062</p>
 * <p>Description: 不同路径</p>
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class L0062 {

    public static void main(String[] args) {
        System.out.println(new L0062().uniquePaths(3, 2));
    }

    /**
     * 回溯算法（超时）
     */
    private int count = 0;
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            count++;
            return count;
        }
        if (m < 1 || n < 1) {
            return 0;
        }
        uniquePaths(m - 1, n);
        uniquePaths(m, n - 1);
        return count;
    }

    /**
     * 动态规划
     */
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
