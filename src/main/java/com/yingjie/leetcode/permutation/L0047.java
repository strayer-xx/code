package com.yingjie.leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: L0047</p>
 * <p>Description: 47. 全排列 II</p>
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * <a href="https://leetcode.cn/problems/permutations-ii/">...</a>
 */
public class L0047 {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        traceback(nums);
        return result;
    }

    private void traceback(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                traceback(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
