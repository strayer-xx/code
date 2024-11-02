package com.yingjie.leetcode.monotonicstack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 经典模板
 * 739. 每日温度
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * <a href="https://leetcode.cn/problems/daily-temperatures/description/">...</a>
 */
public class L0739 {

    /**
     *  构造一个单调递减Deque
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && temperatures[d.peekLast()] < temperatures[i]) {
                int idx = d.pollLast();
                ans[idx] = i - idx;
            }
            d.addLast(i);
        }
        return ans;
    }
}
