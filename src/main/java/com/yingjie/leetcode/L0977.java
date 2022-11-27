package com.yingjie.leetcode;

/**
 * <p>Title: L0977</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/11/27 17:20
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
