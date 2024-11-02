package com.yingjie.leetcode.greedy;

import java.util.Arrays;

/**
 * <p>Title: L0135</p>
 * <p>Description: 135. 分发糖果</p>
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 *
 * <a href="https://leetcode.cn/problems/candy/">...</a>
 */
public class L0135 {

    /**
     * 左规则： 当 ratings[B] > ratings[A] 时，B 的糖比 A 的糖数量多。
     * 右规则： 当 ratings[A] > ratings[B] 时，A 的糖比 B 的糖数量多。
     *
     * 相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则。
     */

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
