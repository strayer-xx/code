package com.yingjie.leetcode.dp;

/**
 * <p>Title: L0152</p>
 * <p>Description: 152. 乘积最大子数组</p>
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32位整数。
 * 子数组 是数组的连续子序列。
 *
 * 链接：<a href="https://leetcode.cn/problems/maximum-product-subarray">...</a>
 */
public class L0152 {

    /**
     * minArr[i] 代表以nums[i]结尾的最小连续子序列乘积
     * maxArr[i] 代表以nums[i]结尾的最大连续子序列乘积
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] minArr = new int[len];
        int[] maxArr = new int[len];
        minArr[0] = nums[0];
        maxArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] < 0) {
                // 为负数，以[i-1]结尾的子序列乘积越大，则加入nums[i]后的乘积越小
                minArr[i] = Math.min(maxArr[i-1] * nums[i], nums[i]);
                // 为负数，以[i-1]结尾的子序列乘积越小，则加入nums[i]后的乘积越大
                maxArr[i] = Math.max(minArr[i-1] * nums[i], nums[i]);
            } else {
                minArr[i] = Math.min(minArr[i-1] * nums[i], nums[i]);
                maxArr[i] = Math.max(maxArr[i-1] * nums[i], nums[i]);
            }
        }
        int ans = maxArr[0];
        for (int i = 1; i < len; ++i) {
            ans = Math.max(ans, maxArr[i]);
        }
        return ans;
    }

    public int maxProduct2(int[] nums) {
        int res = Integer.MIN_VALUE;
        int length = nums.length;
        // 由于乘积存在负负得正的情况，所以无法简单判断加入或者不加入就确定动态转移方程
        // 定义：以 nums[i] 结尾的子数组，乘积最大为 dp1[i]
        int[] dp1 = new int[length];
        // 定义：以 nums[i] 结尾的子数组，乘积最小为 dp2[i]
        int[] dp2 = new int[length];
        // base case
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < length; i++) {
            // dp1取值为最大最小乘积中的最大值
            dp1[i] = Math.max(Math.max(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]), nums[i]);
            // dp2取值为最大最小乘积中的最小值
            dp2[i] = Math.min(Math.min(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]), nums[i]);
        }
        // 遍历取最值
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp1[i]);
        }
        return res;
    }
}
