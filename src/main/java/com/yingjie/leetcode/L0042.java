package com.yingjie.leetcode;

/**
 * <p>Title: L0042</p>
 * <p>Description: 接水滴</p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2022/4/17 12:26
 */
public class L0042 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划
     * 解题要点：设发f(i)为i处的储水量，那么f(i) = Min(left_max - right_max) - height[i]
     * left_max: i左处的最大值
     * right_maxL i右处的最大值
     */
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                leftMax[i] = height[i];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
        }
        for (int i = len -1; i >= 0; i--) {
            if (i == len -1) {
                rightMax[i] = height[i];
            } else {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
        }
        for (int i = 1; i < len-1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }


    /**
     * 双指针
     */
    public int trap1(int[] height) {
        int ans = 0;
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        while(left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
