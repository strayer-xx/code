package com.yingjie.leetcode;

import java.util.Arrays;

/**
 * <p>Title: L0034</p>
 * <p>Description: 在排序数组中查找元素的第一个和最后一个位置</p>
 *给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class L0034 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L0034().searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                low = high = mid;
                break;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (nums[mid] != target) {
            return new int[]{-1, -1};
        }
        while (low > 0 && nums[low - 1] == target) {
            low--;
        }
        while (high < nums.length - 1 && nums[high + 1] == target) {
            high++;
        }

        return new int[]{low, high};
    }
}
