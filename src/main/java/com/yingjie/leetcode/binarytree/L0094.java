package com.yingjie.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>Title: L0094</p>
 * <p>Description: 二叉树的中序遍历</p>
 *
 *给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 */
public class L0094 {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        recursion(root);
        return result;
    }

    private void recursion(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        recursion(root.left);
        result.add(root.val);
        recursion(root.right);
    }



    public class TreeNode {
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
