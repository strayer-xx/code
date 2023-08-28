package com.yingjie.leetcode.slidewindow;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Title: L0239</p>
 * <p>Description: 239. 滑动窗口最大值</p>

 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class L0239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }

        ans[0] = queue.peek()[0];

        for (int i = k; i < n; ++i) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }
}
