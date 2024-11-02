package com.yingjie.leetcode.dp;

/**
 * <p>Title: L0055</p>
 * <p>Description: </p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * <a href="https://leetcode.cn/problems/jump-game/">...</a>
 */
public class L0055 {

    /**
     * 核心思想其实是动态规划，dp[i]记录nums[i]之前所能到达的最远距离，
     * dp[i] = max(dp[i-1], i + nums[i])，空间优化可以将dp[i]变为dp，dp就是题解中的k
     */
    public boolean canJump(int[] nums) {
        int k = nums[0];
        for (int i = 0; i <= k; i++) {
            k = Math.max(k, i + nums[i]);
            if (k >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
