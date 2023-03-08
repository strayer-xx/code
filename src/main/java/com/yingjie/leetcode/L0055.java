package com.yingjie.leetcode;

/**
 * <p>Title: L0055</p>
 * <p>Description: </p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class L0055 {

    /**
     * 思路很简单，主要是代码实现的过程中会有一些没有想到的点
     * 其中k的运用就很巧妙
     */
    public boolean canJump(int[] nums) {
        int k = nums[0];
        for (int i = 0; i <= k; i++) {
            k = Math.max(k, i + nums[i]);
            if (k >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
