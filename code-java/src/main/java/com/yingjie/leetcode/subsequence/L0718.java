package com.yingjie.leetcode.subsequence;


/**
 * 718. 最长重复子数组
 *
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 *
 * <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/">...</a>
 *
 * Next: {@link L1143}
 */
public class L0718 {

    /**
     * 动态规划
     * dp[i][j] 代表两个数组分别以 i-1 和 j-1 为结尾的公共子数组长度
     *
     */
    public int findLength(int[] nums1, int[] nums2) {
        // 便于初始化
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

}
