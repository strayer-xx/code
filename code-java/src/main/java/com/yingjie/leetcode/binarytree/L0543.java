package com.yingjie.leetcode.binarytree;

/**
 * <p>Title: L0543</p>
 * <p>Description: 二叉树的直径</p>
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">...</a>
 */
public class L0543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root.right == null && root.left == null) {
            return 1;
        }
        int left = root.left == null ? 0 : dfs(root.left);
        int right = root.left == null ? 0 : dfs(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
