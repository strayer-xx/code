package com.yingjie.leetcode.bag;

/**
 * <p>Title: L0494</p>
 * <p>Description: </p>
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 */
public class L0494 {

    public static void main(String[] args) {
        System.out.println(new L0494().findTargetSumWays2(new int[]{0,0,0,0,0,0,0,0,1}, 1));
    }

    private int conut = 0;

    /**
     * BFS
     */
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target, 0);
        return conut;
    }

    public void dfs(int[] nums, int index, int target, int sum) {
        if (index >= nums.length) {
            if (sum == target) {
                conut++;
            }
            return;
        }
        dfs(nums, index + 1, target, sum - nums[index]);
        dfs(nums, index + 1, target, sum + nums[index]);
    }

    /**
     * 动态规划-01背包
     * 定义二维数组 dp，其中 dp[i][j] 表示在数组 nums 的前 i个数中选取元素，
     * 使得这些元素之和等于 j 的方案数
     */
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
