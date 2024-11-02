package com.yingjie.leetcode.permutation;

import java.util.*;

/**
 * <p>Title: L0046</p>
 * <p>Description: </p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class L0046 {

    public static void main(String[] args) {
        System.out.println(new L0046().permute(new int[]{1,2,3}).toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(nums, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void backtrace(int[] nums, List<Integer> item, List<List<Integer>> ans) {
        if (item.size() == nums.length) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int num : nums) {
            // 已经选了不能选
            if (item.contains(num)) {
                continue;
            }
            item.add(num);
            backtrace(nums, item, ans);
            item.remove(item.size() - 1);
        }

    }
}
