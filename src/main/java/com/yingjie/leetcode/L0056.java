package com.yingjie.leetcode;

import java.util.*;

/**
 * <p>Title: L0056</p>
 * <p>Description: </p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * <a href="https://leetcode.cn/problems/merge-intervals/description/?favorite=2cktkvj">...</a>
 */
public class L0056 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new L0056().merge(new int[][]{{2,11},{5,10},{15,18}})));
    }

    /**
     * 思路：先按第一个元素排序
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Stack<int[]> result = new Stack<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result.peek()[1]) {
                if (intervals[i][1] > result.peek()[1]){
                    result.peek()[1] = intervals[i][1];
                }
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
