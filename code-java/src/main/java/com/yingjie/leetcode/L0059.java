package com.yingjie.leetcode;

/**
 * <p>Title: L0059</p>
 * <p>Description: 59. 螺旋矩阵 II</p>
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/">...</a>
 */
public class L0059 {

    public int[][] generateMatrix(int n) {
        int a = 0, b = n - 1, c = n - 1, d = 0;
        int num = 1;
        int[][] matrix = new int[n][n];
        while (num <= n * n) {
            for (int i = a; i <= b; i++) {
                matrix[d][i] = num;
                num++;
            }
            d++;
            for (int i = d; i <= c; i++) {
                matrix[i][b] = num;
                num++;
            }
            b--;
            for (int i = b; i >= a; i--) {
                matrix[c][i] = num;
                num++;
            }
            c--;
            for (int i = c; i >= d; i--) {
                matrix[i][a] = num;
                num++;
            }
            a++;
        }
        return matrix;
    }
}
