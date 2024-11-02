package com.yingjie.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Title: L0215</p>
 * <p>Description: 数组中的第K个最大元素</p>
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">...</a>
 */
public class L0215 {

    /**
     * 利用优先队列的二叉堆，时间复杂度 O(nlogK)
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < len; i++) {
            Integer topE = queue.peek();
            if (nums[i] > topE) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
