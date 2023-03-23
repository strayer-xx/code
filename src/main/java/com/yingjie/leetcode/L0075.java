package com.yingjie.leetcode;

import java.util.Arrays;

/**
 * <p>Title: L0075</p>
 * <p>Description: </p>
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <a href="https://leetcode.cn/problems/sort-colors/description/">...</a>
 */
public class L0075 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,0};
        new L0075().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

    public void sortColors2(int[] nums) {
        //统计0，1，2的个数
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        //按照0，1，2的顺序以及统计的个数，重置 nums数组
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

}
