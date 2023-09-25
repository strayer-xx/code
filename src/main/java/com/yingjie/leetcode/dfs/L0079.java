package com.yingjie.leetcode.dfs;


/**
 * 79. 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * <a href="https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
public class L0079 {

    public static void main(String[] args) {
        new L0079().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB");
    }

    private boolean result = false;

    private boolean[][] visited;


    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, 0, board, word);
            }
        }
        return result;
    }

    public void dfs(int x, int y, int deep, char[][] board, String word) {
        if (!inArea(x, y, board) || visited[x][y]) {
            return;
        }
        if (board[x][y] != word.charAt(deep)) {
            return;
        }

        if (deep == word.length() - 1) {
            result = true;
            return;
        }
        visited[x][y] = true;
        dfs(x + 1, y, deep + 1, board, word);
        dfs(x - 1, y, deep + 1, board, word);
        dfs(x, y + 1, deep + 1, board, word);
        dfs(x, y - 1, deep + 1, board, word);
        visited[x][y] = false;
    }

    private boolean inArea(int x, int y, char[][] board) {
        if (x < 0 || x > board.length - 1
                || y < 0 || y > board[0].length - 1) {
            return false;
        }
        return true;
    }

}
