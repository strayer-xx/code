package com.yingjie.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: L0337</p>
 * <p>Description: 337. 打家劫舍 III</p>
 *
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * <a href="https://leetcode.cn/problems/house-robber-iii/">...</a>
 */
public class L0337 {
    // 选择节点
    private Map<TreeNode, Integer> f = new HashMap<>();
    // 不选择节点
    private Map<TreeNode, Integer> g = new HashMap<>();

    /**
     * dp
     */
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }


    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        f.put(root, g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0) + root.val);
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
                + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
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
