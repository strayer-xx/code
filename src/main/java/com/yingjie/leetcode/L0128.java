package com.yingjie.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Title: L0128</p>
 * <p>Description: </p>
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 链接：<a href="https://leetcode.cn/problems/longest-consecutive-sequence">...</a>
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class L0128 {

    public static void main(String[] args) {
        new L0128().longestConsecutive(new int[]{100,4,200,1,3,2});
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        int longest = 0;
        int len;
        for (Integer num : numSet) {
            len = 1;
            // 剪枝，要不然会超时
            if (numSet.contains(num - 1)) {
                continue;
            }
            while (numSet.contains(num + 1)) {
                num++;
                len++;
            }
            longest = Math.max(longest, len);
        }
        return longest;
    }
}
