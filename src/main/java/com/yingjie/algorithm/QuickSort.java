package com.yingjie.algorithm;

import java.util.Arrays;

/**
 * <p>Title: QuickSort</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/3/23 22:10
 */
public class QuickSort {
    public static void quickSort(int[] nums, int left, int right){
        int i, j, t, temp;
        if(left >= right) {
            return;
        }
        // 以最左边为基准数，此时应注意每次排序由j先动
        temp = nums[left];
        i = left;
        j = right;
        while(i < j) {
            while(nums[j] >= temp && i < j) {
                j--;
            }
            while(nums[i] <= temp && i < j) {
                i++;
            }
            if(i < j) {
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {3,4,6,2,4,4,7,4,5};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
