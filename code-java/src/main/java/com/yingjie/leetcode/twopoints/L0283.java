package com.yingjie.leetcode.twopoints;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * <p>示例 1:
 * <p>输入: nums = [0,1,0,3,12]
 * <p>输出: [1,3,12,0,0]
 *
 * <p>示例 2:
 * <p>输入: nums = [0]
 * <p>输出: [0]
 *
 * <p><a href="https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked">link</a>
 *
 * @author L.
 * @since 2026-01-29
 */
public class L0283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        new L0283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int a = 0;
        int b = nums.length - 1;
        while (a < b) {
            if (nums[a] == 0) {
                moveAToB(nums, a, b);
                b--;
            } else {
                a++;
            }

        }
    }

    public void moveAToB(int[] nums, int a, int b) {
        int temp;
        while (a < b) {
            temp = nums[a];
            nums[a] = nums[a + 1];
            nums[a + 1] = temp;
            a++;
        }
    }

    /**
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 注意到以下性质：
     * 1、左指针左边均为非零数；
     * 2、右指针左边直到左指针处均为零。
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     */
    public void moveZeroes1(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
