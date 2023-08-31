package com.yingjie.leetcode.dfs;


/**
 * 695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * <a href="https://leetcode.cn/problems/max-area-of-island/">...</a>
 *
 */
public class L0695 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    private int area(int[][] grid, int l, int r) {
        if (!inArea(grid, l, r)) return 0;
        if (grid[l][r] != 1) return 0;

        grid[l][r] = 2;

        return 1 + area(grid, l - 1, r)
                + area(grid, l, r - 1)
                + area(grid, l + 1, r)
                + area(grid, l, r + 1);
    }

    private boolean inArea(int[][] grid, int l, int r) {
        return 0 <= l && l < grid.length
                && 0 <= r && r < grid[0].length;
    }

}
