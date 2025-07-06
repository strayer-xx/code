package com.yingjie.leetcode;

import java.util.Arrays;

/**
 * 80. 删除有序数组中的重复项 II
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/">...</a>
 */
public class L0080 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        new L0080().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int cur = 0, next;
        int goTailSize = 0;
        if (nums.length <= 2) {
            return nums.length;
        }
        while (cur < nums.length - goTailSize - 2) {
            next = cur + 1;
            if (nums[cur] == nums[next] && nums[next] == nums[next + 1]) {
                goTailSize++;
                goTail(nums, next + 1);
            } else {
                cur++;
            }
        }
        return nums.length - goTailSize;
    }

    private void goTail(int[] nums, int index) {
        while (index < nums.length - 1) {
            int tmp = nums[index + 1];
            nums[index + 1] = nums[index];
            nums[index] = tmp;
            index++;
        }
    }


}
