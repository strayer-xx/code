package com.yingjie.leetcode;

/**
 * <p>Title: L0027</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/11/26 15:20
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
