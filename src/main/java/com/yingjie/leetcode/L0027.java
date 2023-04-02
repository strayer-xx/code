package com.yingjie.leetcode;

/**
 * <p>Title: L0027</p>
 * <p>Description: 移除元素</p>
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2
 */
public class L0027 {

    public static void main(String[] args) {
    }

    /**
     * 将需要移除的元素和末尾的元素进行交换
     */
    public int removeElement(int[] nums, int val) {
        int tail = nums.length - 1;
        int i = 0;
        while (i <= tail) {
            if (nums[i] == val) {
                int temp = nums[tail];
                nums[tail] = nums[i];
                nums[i] = temp;
                tail--;
                continue;
            }
            i++;
        }
        return tail + 1;
    }
}
