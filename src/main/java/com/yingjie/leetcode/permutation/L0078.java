package com.yingjie.leetcode.permutation;

import java.util.*;

/**
 * <p>Title: L0078</p>
 * <p>Description: 子集</p>
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class L0078 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        traceback(0, nums);
        return result;
    }

    public void traceback(int cur, int[] nums) {
        // 注意为什么要cur == nums.length时添加
        if (cur == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[cur]);
        traceback(cur + 1, nums);
        path.remove(path.size() - 1);
        traceback(cur + 1, nums);
    }

    public List<List<Integer>> subsetsDFS(int[] nums) {
        dfs(0, nums, true, new ArrayList<>());
        dfs(0, nums, false, new ArrayList<>());
        return result;
    }

    public void dfs(int cur, int[] nums, boolean flag, List<Integer> list) {

        if (flag) {
            list.add(nums[cur]);
        }
        if (cur == nums.length - 1) {
            result.add(list);
            return;
        }
        dfs(cur + 1, nums, false, new ArrayList<>(list));
        dfs(cur + 1, nums, true, new ArrayList<>(list));
    }

    public static void main(String[] args) {
        System.out.println(new L0078().subsets(new int[]{1,2,3}));
    }
}
