package com.yingjie.leetcode;

/**
 * <p>Title: L0059</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/11/27 18:04
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
