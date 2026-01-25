package com.yingjie.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和</br>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。</br>
 * <p>
 * https://leetcode.cn/problems/longest-consecutive-sequence
 *
 * @author L.
 * @since 2026-01-25
 */
public class L0001 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L0001().twoSum(new int[] {2, 7, 11, 15}, 9)));
    }

    /**
     * hash表（空间换时间）
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
