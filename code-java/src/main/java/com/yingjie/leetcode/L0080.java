package com.yingjie.leetcode;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/">...</a>
 */
public class L0080 {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int next,cur = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            cur = i;
            next = i + 1;
            while (nums[next] == nums[cur] && next + 1 < nums.length) {
                if (nums[next] == nums[next + 1]) {
                    goTail(nums, next + 1);
                }
            }
        }
        return 0;
    }

    private void goTail(int[] nums, int index) {
        while (index + 1 < nums.length) {
            int temp = nums[index];
            nums[index] = nums[index + 1];
            nums[index + 1] = temp;
            index++;
        }
    }
}
