package com.yingjie.leetcode;

/**
 * <p>Title: L0096</p>
 * <p>Description: 不同的二叉搜索树</p>
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 * 输入：n = 3
 * 输出：5
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/">...</a>
 */
public class L0096 {

    public static void main(String[] args) {
        System.out.println(new L0096().numTrees(3));
    }

    /**
     * 给定序列 1⋯n，我们选择数字 i 作为根，则根为 i 的所有二叉搜索树的集合是左子树集合和右子树集合的笛卡尔积,
     * 对于笛卡尔积中的每个元素，加上根节点之后形成完整的二叉搜索树
     * <a href="https://leetcode.cn/problems/unique-binary-search-trees/solutions/329807/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/">...</a>
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
