package com.yingjie.leetcode.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: L0560</p>
 * <p>Description: 和为 K 的子数组</p>

 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class L0560 {

    /**
     * 暴力
     */
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和
     */
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> prefixMap = new HashMap<>(len);
        prefixMap.put(0, 1);
        int pre = 0;
        int count = 0;
        for (int num : nums) {
            pre += num;
            // pre[i] − pre[j] = k
            if (prefixMap.containsKey(pre - k)) {
                count += prefixMap.get(pre - k);
            }
            prefixMap.put(pre, prefixMap.getOrDefault(pre, 0) + 1);

        }
        return count;
    }
}
