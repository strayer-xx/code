package com.yingjie.leetcode.binarytree;

/**
 * <p>Title: L0226</p>
 * <p>Description: </p>
 *
 * 226. 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">...</a>
 */
public class L0226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
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
