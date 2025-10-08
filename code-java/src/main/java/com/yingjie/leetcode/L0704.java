package com.yingjie.leetcode;

/**
 * <p>Title: L0704</p>
 * <p>Description: </p>
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/11/26 15:01
 */
public class L0704 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        new L0704().search(nums, target);
    }

    /**
     * 1、left和right赋值时一定需要加或减1（两个元素的场景跳不出循环）
     * 2、left和right做比较时一定时<=而不是<（一个元素的场景找不到正确的解）
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 避免int超出
            int mid = (right - left) / 2 + left;
            int midNum = nums[mid];
            if (target == midNum) {
                return mid;
            } else if (target < midNum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
