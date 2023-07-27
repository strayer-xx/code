package com.yingjie.leetcode.dp;

/**
 * <p>Title: L0053</p>
 * <p>Description: 最大子序和</p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/4/16 19:31
 */
public class L0053 {
    public static void main(String[] args) {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {5,4,-1,7,8};
        L0053 solution = new L0053();
        System.out.println(solution.maxSubArray(nums2));

    }

    /**
     * dp[i]代表以nums[i]结尾的最大子序和
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 动态规划
     */
    public int maxSubArrayPro(int[] nums) {
        int result = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            result = Math.max(result, pre);
        }
        return result;
    }
}