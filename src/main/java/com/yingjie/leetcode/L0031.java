package com.yingjie.leetcode;

/**
 * <p>Title: L0031</p>
 * <p>Description: </p>
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * <a href="https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/">...</a>
 **/
public class L0031 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,0,2,3,2,0};
        new L0031().nextPermutation(arr);
    }


    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后向前查找第一个相邻升序的元素对 (i, i+1)
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 因为是升序对所以在i的右边一定有大于nums[i]的数
            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 交换完成之后[i + 1, nums.length)一定是一个降序，需要进行翻转为升序
        reverse(nums, i + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int l, int r){
        // 双指针翻转
        while(l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public void swap(int[] nums, int i, int k){
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }



}
