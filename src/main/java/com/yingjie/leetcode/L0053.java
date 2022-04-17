package com.yingjie.leetcode;

/**
 * <p>Title: L0053</p>
 * <p>Description: 最大子序和</p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/4/16 19:31
 */
public class L0053 {
    public static void main(String[] args) {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {-5,-4,-1,-7,-8};
        L0053 solution = new L0053();
        assert solution.maxSubArray(nums1) == 6 : "failed1";
        assert solution.maxSubArray(nums2) == -1 : "failed2";

    }

    /**
     * 动态规划
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            result = Math.max(result, pre);
        }
        return result;
    }
}