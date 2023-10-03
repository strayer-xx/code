package com.yingjie.leetcode.greedy;

import java.util.Arrays;

/**
 * <p>Title: L0376</p>
 * <p>Description: </p>
 *
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 *
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 *
 * <a href="https://leetcode.cn/problems/wiggle-subsequence/">...</a>
 */
public class L0376 {

    public static void main(String[] args) {
        new L0376().wiggleMaxLength(new int[]{1,1,1,3,3,3,4,5});
    }

    /**
     * 直接计算转折点，注意计算转折点的方法
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int count = 0;
        int preDiff = nums[1] - nums[0];
        int diff;
        count = preDiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            diff = nums[i] - nums[i - 1];
            // 为什么prediff是 <= 而不是 <
            if ((diff > 0 && preDiff <= 0) ||
                    (diff < 0 && preDiff >= 0)) {
                preDiff = diff;
                count++;
            }
        }

        return count;
    }

}
