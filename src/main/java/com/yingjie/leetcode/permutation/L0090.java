package com.yingjie.leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: L0090</p>
 * <p>Description: 子集 II</p>
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * <a href="https://leetcode.cn/problems/subsets-ii/">...</a>
 */
public class L0090 {

    public static void main(String[] args) {
        System.out.println(new L0090().subsetsWithDup(new int[]{1,2,2,2}));
    }

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        traceback(false, 0, nums);
        return result;
    }

    private void traceback(boolean hasChoose, int cur, int[] nums) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        traceback(false, cur + 1, nums);
        // 注意这里为什么可以使用nums[cur] == nums[cur - 1]进行判断
        if (!hasChoose && cur > 0 && nums[cur] == nums[cur - 1]) {
            return;
        }
        path.add(nums[cur]);
        traceback(true, cur + 1, nums);
        path.remove(path.size() - 1);
    }
}
