package com.yingjie.leetcode.dfs;


/**
 * 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * <a href="https://leetcode.cn/problems/number-of-islands/description/">...</a>
 */
public class L0200 {


    /**
     * 题解：<a href="https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/">...</a>
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    area(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void area(char[][] grid, int l, int r) {
        if (!inArea(grid, l, r)) return;
        if (grid[l][r] == '0') return;

        grid[l][r] = '0';

        area(grid, l - 1, r);
        area(grid, l, r - 1);
        area(grid, l + 1, r);
        area(grid, l, r + 1);
    }

    private boolean inArea(char[][] grid, int l, int r) {
        return 0 <= l && l < grid.length
                && 0 <= r && r < grid[0].length;
    }
}
