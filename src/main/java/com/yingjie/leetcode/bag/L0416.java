package com.yingjie.leetcode.bag;

/**
 * <p>Title: L0416</p>
 * <p>Description: </p>
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11]
 */
public class L0416 {

    /**
     * 转化为01背包问题，从nums中取数，看是否有等于sum/2的结果
     */
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >>> 1;
        // dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），
        // 是否存在一种选取方案使得被选取的正整数的和等于 j。初始时，dp 中的全部元素都是 false
        boolean[][] dp = new boolean[nums.length][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    /**
     * 计算 dp 的过程中，每一行的 dp 值都只与上一行的 dp 值有关，
     * 因此只需要一个一维数组即可将空间复杂度降到 O(target)
     */
    public boolean canPartition2(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >>> 1;
        boolean[] dp = new boolean[target + 1];
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
