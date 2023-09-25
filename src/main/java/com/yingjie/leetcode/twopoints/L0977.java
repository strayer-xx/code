package com.yingjie.leetcode.twopoints;

/**
 * <p>Title: L0977</p>
 * <p>Description: 977. 有序数组的平方 </p>
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">...</a>
 */
public class L0977 {

    /**
     * 双指针
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int len = nums.length;
        int[] ans = new int[len];
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                ans[len - 1] = nums[left] * nums[left];
                len--;
                left++;
            } else {
                ans[len - 1] = nums[right] * nums[right];
                len--;
                right--;
            }
        }
        return ans;
    }
}
