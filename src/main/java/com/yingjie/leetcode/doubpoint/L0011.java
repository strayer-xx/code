package com.yingjie.leetcode.doubpoint;

/**
 * <p>Title: L0011</p>
 * <p>Description: 盛最多水的容器</p>
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * <a href="https://leetcode.cn/problems/container-with-most-water/">...</a>
 */
public class L0011 {

    /**
     * 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 −1变短：
     *
     * 若向内 移动短板 ，水槽的短板,下个水槽的面积 可能增大 。
     * 若向内 移动长板 ，水槽的短板,下个水槽的面积 一定变小 。
     */
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int maxArea = 0;
        while (lo < hi) {
            maxArea = Math.max(maxArea, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return maxArea;
    }
}
