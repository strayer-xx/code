package com.yingjie.leetcode;

/**
 * <p>Title: L0674</p>
 * <p>Description: 连续递增的子序列 </p>
 *
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
 * 都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class L0674 {

    public int findLengthOfLCIS(int[] nums) {
        int lo = 0;
        int hi = 1;
        if (nums.length == 1) {
            return 1;
        }
        int res = 0;
        while (hi < nums.length) {
            if (nums[hi - 1] >= nums[hi]) {
                lo = hi;
            }
            hi++;
            res = Math.max(res, hi - lo);
        }
        return res;
    }
}
