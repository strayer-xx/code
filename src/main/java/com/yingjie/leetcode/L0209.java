package com.yingjie.leetcode;

/**
 * <p>Title: L0209</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/11/27 17:32
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
