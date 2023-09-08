package com.yingjie.leetcode.slidewindow;

/**
 * <p>Title: L0209</p>
 * <p>Description:209. 长度最小的子数组 </p>
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">...</a>
 */
public class L0209 {

    /**
     * 滑动窗口
     */
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, len = nums.length;
        int sum = nums[0];
        while (i <= j) {
            if (sum >= target) {
                min = Math.min(j - i + 1, min);
                sum = sum - nums[i];
                i++;
            } else {
                j++;
                if (j >= len) {
                    break;
                }
                sum = sum + nums[j];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
