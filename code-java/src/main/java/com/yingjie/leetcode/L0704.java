package com.yingjie.leetcode;

/**
 * <p>Title: L0704</p>
 * <p>Description: </p>
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
     * right和left赋值时一定需要加或减1
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
