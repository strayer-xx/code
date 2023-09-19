package com.yingjie.leetcode.dp;

/**
 * <p>Title: L0198</p>
 * <p>Description: 198. 打家劫舍</p>
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * <a href="https://leetcode.cn/problems/house-robber/description/">...</a>
 *
 * Next: {@link L0213}
 */
public class L0198 {

    public static void main(String[] args) {
        new L0198().rob2(new int[]{1,2,3,1});
    }

    /**
     * dp[i][0] 在第i个时，不偷的最大值
     * dp[i][1] 在第i个时，偷的最大值
     */
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    /**
     *  将问题类比上楼梯，一次可以上一阶或两阶（重要）
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


    /**
     * dfs(timeout)
     */
    public int rob4(int[] nums) {
        int sum = 0;
        dfs(nums, 0, false, sum);
        return max;
    }

    private int max = 0;
    private void dfs(int[] nums, int index, boolean preState, int sum) {
        if (index >= nums.length) {
            max = Math.max(sum, max);
            return;
        }
        if (preState) {
            dfs(nums, index + 1, false, sum);
        } else {
            dfs(nums, index + 1, true, sum + nums[index]);
            dfs(nums, index + 1, false, sum);
        }
    }
}
