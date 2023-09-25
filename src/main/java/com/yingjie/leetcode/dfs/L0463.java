package com.yingjie.leetcode.dfs;


/**
 * 463. 岛屿的周长
 *
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，
 * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * <a href="https://leetcode.cn/problems/island-perimeter/">...</a>
 *
 * Next: {@link L0695}
 */
public class L0463 {

    public int islandPerimeter(int[][] grid) {
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
        if (!inArea(grid, l, r)) return 1;
        if (grid[l][r] == 0) return 1;
        if (grid[l][r] == 2) return 0;

        grid[l][r] = 2;

        return area(grid, l - 1, r)
                + area(grid, l, r - 1)
                + area(grid, l + 1, r)
                + area(grid, l, r + 1);
    }

    private boolean inArea(int[][] grid, int l, int r) {
        return 0 <= l && l < grid.length
                && 0 <= r && r < grid[0].length;
    }
}
